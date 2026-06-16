package library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import library.data.User;

@Repository

public interface UserRepository extends JpaRepository<User,Long> {
	Optional<User> findUserByEmail(String email);
	
	boolean existsByEmail(String email);
}
