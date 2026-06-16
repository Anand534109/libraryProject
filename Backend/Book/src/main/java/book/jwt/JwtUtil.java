package book.jwt;

import java.security.Key;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Component
@PropertySource("classpath:book.properties")
public class JwtUtil{
	@Value("${jwt.SECRET}")
	private String SECRET;
	
	public Key getKey() {
		return Keys.hmacShaKeyFor(SECRET.getBytes());
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parser()
			.verifyWith((SecretKey)getKey())
			.build()
			.parseSignedClaims(token);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}
} 
