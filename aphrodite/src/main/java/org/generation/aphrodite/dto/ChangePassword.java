package org.generation.aphrodite.dto;

public class ChangePassword {
	private String password;
	private String npassword;
	
	public ChangePassword(String password, String npassword) {
		super();
		this.password = password;
		this.npassword = npassword;
	}//constructor
	
	public ChangePassword() {
		
	}//constructor vacío

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNpassword() {
		return npassword;
	}

	public void setNpassword(String npassword) {
		this.npassword = npassword;
	}
	//getters and setters

	@Override
	public String toString() {
		return "ChangePassword [password=" + password + ", npassword=" + npassword + "]";
	}//toString
	
	
}//class ChangePassword
