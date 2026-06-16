package library.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import library.services.CustomUserDetail;
import library.services.ImpUserDetailService;

@Component
public class JwtFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired 
	private ImpUserDetailService impUserDetail;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		 
//		String authHeader = request.getHeader("Authorization");
		String token = null;
		String email = null;
//		
//		if(authHeader != null && authHeader.startsWith("Bearer")) {
//			token = authHeader.substring(7);
//			try {
//				email = jwtUtil.extractUsername(token);	
//			}catch(ExpiredJwtException e) {
//			    response.setStatus(401);
//			    response.getWriter().write("JWT Token Expired");
//			    return;
//			}
//		}
		System.out.println("jwt filter run");
		Cookie []cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie:cookies) {
				cookie.getName().equals("jwtToken");
				token = cookie.getValue();
			}
		}
		
		if(token == null) {
			response.setStatus(401);
		}
		
		if(token != null) {
			try {
				email = jwtUtil.extractUsername(token);	
			}catch(ExpiredJwtException e) {
			    response.setStatus(401);
			    response.getWriter().write("JWT Token Expired");
			    return;
			}
		}
		
		if(email != null && SecurityContextHolder.getContext().getAuthentication()== null) {
			CustomUserDetail customUser =(CustomUserDetail) impUserDetail.loadUserByUsername(email);
			
			if(jwtUtil.isTokenValid(token, customUser)) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(customUser,null,null);
				
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request) );
				
				SecurityContextHolder.getContext().setAuthentication(authToken);
				
			}
		}
		
		filterChain.doFilter(request, response);
	}

}
