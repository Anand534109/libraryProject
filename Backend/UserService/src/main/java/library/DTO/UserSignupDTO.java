package library.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserSignupDTO {
	
	@NotBlank(message = "firstname is required")
	@Pattern(regexp="^[a-zA-z0-9]+$",message ="invalid user name"	)
	private String firstName;
	
	@NotBlank(message ="lastname is required")
	@Pattern(regexp="^[a-zA-z0-9]+$",message ="invalid user name"	)
	private String lastName;
	
	@NotBlank(message ="email  is required")
	@Email(message="email is not valid")
	private String email;
	@NotBlank(message="password is required")
	@Pattern(
			regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z\\d]).{8,}$",
			message="password should be contain small,capital,numaric value and atleast one special character"
			)
	private String password;
	
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
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
		return "UserSignupDTO [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + "]";
	}

	
	
	
}
