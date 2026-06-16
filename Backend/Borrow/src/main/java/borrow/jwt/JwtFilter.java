package borrow.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token =  null;
		Cookie cookies[] = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie:cookies) {
				cookie.getName().equals("jwtToken");
				token = cookie.getValue();	
			}
		}
		
		if(token != null && jwtUtil.validateToken(token)) {
			filterChain.doFilter(request, response);
		}
		else
		{
			response.setStatus(401);
			response.getWriter().write("please login first");
		}
		
	}

}
