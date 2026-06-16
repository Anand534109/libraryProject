package library.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserLoginDTO {
	
	@NotBlank(message ="email is required")
	@Email(message ="email is not valid")
	private String email;
	
	@NotBlank(message ="password is required")
	@Pattern(
			regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[a-zA-z\\d]).{8,}$",
			message="password should be contain small,capital,numaric value and atleast one special character"
			)
	private String password;
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserLoginDTO [email=" + email + ", password=" + password + "]";
	}
	
	
}
