package com.jchat.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RegisterScreen extends Screen {
	private final String FIRST_NAME = "First Name";
	private final String LAST_NAME = "Last Name";
	private final String EMAIL = "Email";
	private final String USERNAME = "Username";
	private final String PASSWORD = "Password";
	private final String REPEAT_PASSWORD = "Repeat Password";
	private final String REGISTER = "Register Now";
	private final String LOGIN = "Back to Login";
	
	private Label lblFirstName;
	private Label lblLastName;
	private Label lblEmail;
	private Label lblUsername;
	private Label lblPassword;
	private Label lblRepeatPassword;
	private Button btnRegister;
	private Button btnLogin;
	
	private String screenTitle;
	

	public RegisterScreen(String screenTitle, int initialWidth, int initialHeight, int minWidth, int minHeight) {
		super(screenTitle, initialWidth, initialHeight, minWidth, minHeight);
		
		lblFirstName = new Label(FIRST_NAME);
		lblLastName = new Label(LAST_NAME);
		lblEmail = new Label(EMAIL);
		lblUsername = new Label(USERNAME);
		lblPassword = new Label(PASSWORD);
		lblRepeatPassword = new Label(REPEAT_PASSWORD);
		btnRegister = new Button(REGISTER);
		btnLogin = new Button(LOGIN);
	
	}
	
	/*
	 * TODO - Set up the scene for register screen
	 */
	public Scene instantiateScene() {
		return null;
	}

}