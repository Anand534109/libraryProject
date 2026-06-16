package library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import library.DTO.UserSignupDTO;
import library.data.User;
import library.repository.UserRepository;

@Service
public class SignupServiceImp implements UserSignupService {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void saveUser(UserSignupDTO user) {
		if(userRepo.existsByEmail(user.getEmail())) {
			throw new RuntimeException(" this User already exist");
		}else {
			User newUser = new User();
			newUser.setFirstName(user.getFirstName());
			newUser.setLastName(user.getLastName());
			newUser.setEmail(user.getEmail());
			newUser.setPassword(passwordEncoder.encode(user.getPassword()));
			newUser.setRole("ROLE_USER");
			userRepo.save(newUser);			
		} 
		
	}

	@Override
	public boolean existEmail(String email) {
		boolean user =userRepo.existsByEmail(email);
		if(user) {
			return true;
		}
		return false;
	}

	@Override
	public User getUserById(long id) {
		User user = userRepo.findById(id).orElse(null);
		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = userRepo.findUserByEmail(email).orElse(null);
		return user;
	}

}
