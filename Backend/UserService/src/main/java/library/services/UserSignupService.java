package library.services;

import library.DTO.UserSignupDTO;
import library.data.User;

public interface UserSignupService {
	public void saveUser(UserSignupDTO user);
	
	public boolean existEmail(String email);
	
	public User getUserById(long id);
	public User getUserByEmail(String email);
}
