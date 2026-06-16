package library.jwt;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import library.data.User;
import library.services.CustomUserDetail;


@Component
@PropertySource("classpath:application.properties")
public class JwtUtil{
	@Value("${jwt.SECRET}")
	private String SECRET;
	
	public Key getKey() {
		return Keys.hmacShaKeyFor(SECRET.getBytes());
	}
	
	public String generateToken(User user) {
		return Jwts.builder()
				.subject(user.getEmail())
				.claim("id", user.getId())
				.claim("role", user.getRole())
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis()+1000*60*10))
				.signWith(getKey())
				.compact();
	}
	
	public Claims getClaims(String token) {
		return Jwts.parser()
				.verifyWith((SecretKey)getKey())
				.build()
				.parseSignedClaims(token)
				.getPayload();	
	}
	
	public long extractId(String token) {
		return getClaims(token).get("id",Long.class);
	}
	
	public String extractUsername(String token) {
		return getClaims(token).getSubject();	
	}
	
	public boolean istokenExpired(String token) {
		return getClaims(token).getExpiration().before(new Date());
	}
	
	public boolean isTokenValid(String token,CustomUserDetail userdetail) {
		String email = extractUsername(token);
		if(email.equals(userdetail.getUsername()) && !istokenExpired(token)) {
			return true;
		}
		return false;
	}
} 
