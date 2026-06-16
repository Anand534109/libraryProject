package library.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import library.DTO.UserDTO;
import library.DTO.UserLoginDTO;
import library.DTO.UserSignupDTO;
import library.data.User;
import library.jwt.JwtUtil;
import library.repository.UserRepository;
import library.services.CustomUserDetail;
import library.services.ImpUserDetailService;
import library.services.UserSignupService;

@RestController
public class UserController {
	
	@Autowired
	private UserSignupService signupservice;
	@Autowired
	private UserRepository userRepo;
	@Autowired 
	private ImpUserDetailService impUser;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@Valid @RequestBody UserSignupDTO user,BindingResult result){
		if(result.hasErrors()) {
			Map<String,String> errors = new HashMap<>();
			result.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(errors);
		}
		signupservice.saveUser(user); 
		return ResponseEntity.ok().body("user successfully registered");
	} 
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody UserLoginDTO user,BindingResult result , HttpServletResponse response){
		System.out.println(user);
		if(result.hasErrors()) {
			Map<String,String> errors = new HashMap<>();
			result.getFieldErrors().forEach(error-> errors.put(error.getField(), error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(errors);
		}
		
		Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
		                user.getEmail(),
		                user.getPassword()
		            )
		        );
		SecurityContextHolder.getContext().setAuthentication(authentication);
		CustomUserDetail customUser =(CustomUserDetail) authentication.getPrincipal();
		String token = jwtUtil.generateToken(customUser.getUser());
		
		Cookie cookie = new Cookie("jwtToken",token);
		cookie.setHttpOnly(true);
		cookie.setPath("/");
		cookie.setMaxAge(60*10);
		response.addCookie(cookie);
		return ResponseEntity.ok().body("login successfully");
	}
	
	@PostMapping("/logoutAccount")
	public ResponseEntity<?> logout(HttpServletResponse response){
		Cookie cookie = new Cookie("jwtToken","");
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		return ResponseEntity.ok().body("logout Successfully");
	}
	
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") long id) {
		return signupservice.getUserById(id);
	}
	
	@GetMapping("/auth/me")
	public ResponseEntity<UserDTO> me(Authentication authentication){
//		System.out.println(authentication);
		if(authentication == null) {
			 return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		String email = authentication.getName();
		User user = signupservice.getUserByEmail(email);
	
		UserDTO userDto = new UserDTO();
		userDto.setId(user.getId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());
		System.out.println(userDto);
		return ResponseEntity.ok().body(userDto);
	}
}	



