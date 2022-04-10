package com.flyaway;
import javax.persistence.Id;
import javax.persistence.Entity;
@Entity
public class UserClass {
	@Id
	private String FirstName;
	private String LastName;
	private String Email;
	private String Password;
	private String mobileNo;
	
	
	public UserClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserClass [FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + ", Password="
				+ Password + ", mobileNo=" + mobileNo + "]";
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	


}
