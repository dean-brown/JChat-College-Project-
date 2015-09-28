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
		//TODO - Set up the scene
		return null;
	}

	public Label getLblFirstName() {
		return lblFirstName;
	}

	public void setLblFirstName(Label lblFirstName) {
		this.lblFirstName = lblFirstName;
	}

	public Label getLblLastName() {
		return lblLastName;
	}

	public void setLblLastName(Label lblLastName) {
		this.lblLastName = lblLastName;
	}

	public Label getLblEmail() {
		return lblEmail;
	}

	public void setLblEmail(Label lblEmail) {
		this.lblEmail = lblEmail;
	}

	public Label getLblUsername() {
		return lblUsername;
	}

	public void setLblUsername(Label lblUsername) {
		this.lblUsername = lblUsername;
	}

	public Label getLblPassword() {
		return lblPassword;
	}

	public void setLblPassword(Label lblPassword) {
		this.lblPassword = lblPassword;
	}

	public Label getLblRepeatPassword() {
		return lblRepeatPassword;
	}

	public void setLblRepeatPassword(Label lblRepeatPassword) {
		this.lblRepeatPassword = lblRepeatPassword;
	}

	public Button getBtnRegister() {
		return btnRegister;
	}

	public void setBtnRegister(Button btnRegister) {
		this.btnRegister = btnRegister;
	}

	public Button getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(Button btnLogin) {
		this.btnLogin = btnLogin;
	}

	public String getScreenTitle() {
		return screenTitle;
	}

	public void setScreenTitle(String screenTitle) {
		this.screenTitle = screenTitle;
	}

	public String getFIRST_NAME() {
		return FIRST_NAME;
	}

	public String getLAST_NAME() {
		return LAST_NAME;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public String getREPEAT_PASSWORD() {
		return REPEAT_PASSWORD;
	}

	public String getREGISTER() {
		return REGISTER;
	}

	public String getLOGIN() {
		return LOGIN;
	}
	
	

}