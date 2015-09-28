package com.jchat.ie;

public class User {
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;

	/*
	 * Created when the user loggs in fully
	 */
	public User(String firstName, String lastName, String email, String username , String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	/*
	 * Created as the user logs in
	 */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	/*
	 * Created to help build an address book 
	 */
	public User(String firstName, String lastName, String username) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
	}

	
	public void logOut() {
		firstName = lastName = username = email = password = null;

	}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

}
