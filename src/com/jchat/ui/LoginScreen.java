/*
 * Created my first Screen that extends the Screen class
 * This should be build upon and anything new that all the scenes will
 * have in common should be moved up to the Screen super class and 
 * implemented across all of them
 * 
 * PLEASE NOTE THAT SETTING UP THE VBOX WILL BE MOVED INTO THE SUPER CLASS
 */
package com.jchat.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class LoginScreen extends Screen {
	private final String USERNAME = "Username";
	private final String PASSWORD = "Password";
	private final String BUTTON_LOGIN = "Login";
	private final String BUTTON_REGISTER = "Register";
	private final String REMEMBER_ME = "Remember Me?";
	private String screenTitle;
	
	private Label lblUsername;
	private Label lblPassword;
	private TextField tfUsername;
	private PasswordField pfPassword;
	
	private CheckBox rememberMe;
	private Button btnLogin;
	private Button btnRegister;

	public LoginScreen(String screenTitle, int initialWidth, int initialHeight, int maxWidth, int maxHeight) {
		super(screenTitle, initialWidth, initialHeight, maxWidth, maxHeight);	
		this.screenTitle = screenTitle;
		lblUsername = new Label(USERNAME);
		lblPassword = new Label(PASSWORD);
		tfUsername = new TextField();
		pfPassword = new PasswordField();
		rememberMe = new CheckBox(REMEMBER_ME);
		btnLogin = new Button(BUTTON_LOGIN);
		btnRegister = new Button(BUTTON_REGISTER);
	}
	
	/*
	 * Creates and returns the scene
	 */
	public Scene instantiateScene() {
		VBox loginVBox = new VBox();
		loginVBox.getChildren().addAll(lblUsername, tfUsername, lblPassword, pfPassword, rememberMe,
				btnLogin, btnRegister);
		
		// Create the scene, grab stylesheets and return. . . 
		Scene loginScene = new Scene(loginVBox, initialWidth, initialHeight);
		loginScene.getStylesheets().add("com/jchat/style/base_theme.css");
		return loginScene;
	}

	public String getScreenTitle() {
		return screenTitle;
	}

	public void setScreenTitle(String screenTitle) {
		this.screenTitle = screenTitle;
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

	public Button getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(Button btnLogin) {
		this.btnLogin = btnLogin;
	}

	public Button getBtnRegister() {
		return btnRegister;
	}

	public void setBtnRegister(Button btnRegister) {
		this.btnRegister = btnRegister;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public String getBUTTON_LOGIN() {
		return BUTTON_LOGIN;
	}

	public String getBUTTON_REGISTER() {
		return BUTTON_REGISTER;
	}
}
