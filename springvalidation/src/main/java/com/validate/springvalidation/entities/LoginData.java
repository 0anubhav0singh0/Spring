package com.validate.springvalidation.entities;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginData {
	// jo bhi data aa raha hai wo userName and email me aa raha hai to yaha pe iske
	// upar validation laga sakte ho
	@NotBlank(message = "User Name can not be empty !!") // agar blank anhi chahiye
	@Size(min = 3, max = 12, message = "User name must be between 3-12 characters") // agar size bhi check karni hai to
																					// @Min, @Max, @Size use kar sakte
																					// ho
	private String userName;

	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid Email")
	private String email;

	@AssertTrue(message="Must agree terms and conditions") // iska matlab hoga agar true hoga tabhi ismae data aayega or agar false hoga to
				// error generate ho jayega
	private boolean agreed;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAgreed() {
		return agreed;
	}

	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}

	@Override
	public String toString() {
		return "LoginData [userName=" + userName + ", email=" + email + "]";
	}

}
