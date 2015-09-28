package com.jchat.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class RegisterScreen extends Screen {
	private final String FIRST_NAME = "First Name";
	private final String LAST_NAME = "Last Name";
	private final String EMAIL = "Email";
	private final String USERNAME = "Username";
	private final String PASSWORD = "Password";
	private final String REPEAT_PASSWORD = "Repeat Password";
	private final String REGISTER = "Register Now";
	private final String LOGIN = "Back to Login";
	
	// Notification Strings:
	private final String PASSWORDS_NOT_MATCH = "The passwords do not match!";
	
	private Label lblFirstName;
	private Label lblLastName;
	private Label lblEmail;
	private Label lblUsername;
	private Label lblPassword;
	private Label lblRepeatPassword;
	
	// Notification label:
	private Label lblErrorWithRegistration;
	
	private TextField tfFirstName;
	private TextField tfLastName;
	private TextField tfEmail;
	private TextField tfUsername;
	private PasswordField pfPassword;
	private PasswordField pfRepeatPassword;
	
	private Button btnRegister;
	private Button btnLogin;
	
	private String screenTitle;
	
	public RegisterScreen(String screenTitle, int initialWidth, int initialHeight, int minWidth, int minHeight) {
		super(screenTitle, initialWidth, initialHeight, minWidth, minHeight);
		// Labels
		lblFirstName = new Label(FIRST_NAME);
		lblLastName = new Label(LAST_NAME);
		lblEmail = new Label(EMAIL);
		lblUsername = new Label(USERNAME);
		lblPassword = new Label(PASSWORD);
		lblRepeatPassword = new Label(REPEAT_PASSWORD);
		
		// Notification label
		lblErrorWithRegistration = new Label("");
		
		// Buttons
		btnRegister = new Button(REGISTER);
		btnLogin = new Button(LOGIN);
		
		// Text and password fields
		tfFirstName = new TextField();
		tfLastName = new TextField();
		tfEmail = new TextField();
		tfUsername = new TextField();
		pfPassword = new PasswordField();
		pfRepeatPassword = new PasswordField();
	
	}
	
	/*
	 * Instantiate the Scene Register Scene
	 */
	public Scene instantiateScene() {
		VBox registerScreenVBox = new VBox();
		registerScreenVBox.getChildren().addAll(lblFirstName, tfFirstName, lblLastName, tfLastName, lblEmail, 
				tfEmail, lblUsername, tfUsername, lblPassword, pfPassword, lblRepeatPassword, pfRepeatPassword, btnRegister, btnLogin, lblErrorWithRegistration);
		
		Scene registserScreenScene = new Scene(registerScreenVBox, initialWidth, initialHeight);
		registserScreenScene.getStylesheets().add("com/jchat/style/base_theme.css");
		return registserScreenScene;
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

	public Label getLblErrorWithRegistration() {
		return lblErrorWithRegistration;
	}

	public void setLblErrorWithRegistration(Label lblErrorWithRegistration) {
		this.lblErrorWithRegistration = lblErrorWithRegistration;
	}

	public String getPASSWORDS_NOT_MATCH() {
		return PASSWORDS_NOT_MATCH;
	}

	public void setLblRepeatPassword(Label lblRepeatPassword) {
		this.lblRepeatPassword = lblRepeatPassword;
	}

	public TextField getTfFirstName() {
		return tfFirstName;
	}

	public void setTfFirstName(TextField tfFirstName) {
		this.tfFirstName = tfFirstName;
	}

	public TextField getTfLastName() {
		return tfLastName;
	}

	public void setTfLastName(TextField tfLastName) {
		this.tfLastName = tfLastName;
	}

	public TextField getTfEmail() {
		return tfEmail;
	}

	public void setTfEmail(TextField tfEmail) {
		this.tfEmail = tfEmail;
	}

	public TextField getTfUsername() {
		return tfUsername;
	}

	public void setTfUsername(TextField tfUsername) {
		this.tfUsername = tfUsername;
	}

	public PasswordField getPfPassword() {
		return pfPassword;
	}

	public void setPfPassword(PasswordField pfPassword) {
		this.pfPassword = pfPassword;
	}

	public PasswordField getPfRepeatPassword() {
		return pfRepeatPassword;
	}

	public void setPfRepeatPassword(PasswordField pfRepeatPassword) {
		this.pfRepeatPassword = pfRepeatPassword;
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