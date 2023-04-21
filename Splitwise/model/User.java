package model;
import java.util.UUID;

public class User {
	private String userId;
	private String name;
	private String email;
	private String mobileNumber;
	
	public User(String id, String name, String email, String mobileNo) {
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNo;
		this.userId = id;
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getMobileNo() {
		return this.mobileNumber;
	}
}
