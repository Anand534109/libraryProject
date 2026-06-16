package book.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import book.jwt.JwtFilter;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "book")
public class SpringSecurityConfig {
	
	@Autowired
	private JwtFilter jwtFilter;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors(cors-> {})
		.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(auth -> auth
				.anyRequest()
				.permitAll()
				)
		.sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//		.addFilter(jwtFilter);
		
		return http.build();
	}
	
	@Bean
	public CorsConfigurationSource  corsConfigurationSource() {
		CorsConfiguration cors = new CorsConfiguration();
		cors.setAllowedOrigins(List.of("http://localhost:5173"));
		cors.setAllowedMethods(List.of("*"));
		cors.setAllowedHeaders(List.of("*"));
		cors.setAllowCredentials(true);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", cors);
		return source;
	}
	
}
