/*
 * 
 * I will write this in the manner that the other classes should be wrote in.......
 * 
 */

package com.jchat.ui;

import com.jchat.ie.User;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class HomeScreen extends Screen {
	
	private String firstName = "First Name";
	private String lastName =  "Last Name";
	private String email = "Email";
	private String username = "Username";
	private String password = "Password";
	private String logout = "Logout";
	
	private Label lblFirstName;
	private Label lblLastName;
	private Label lblEmail;
	private Label lblUsername;
	private Label lblPassword;
	
	Button btnLogout;
	
	public HomeScreen(User user, String screenTitle, int initialWidth, int initialHeight, int maxWidth, int maxHeight) {
		super(screenTitle, initialWidth, initialHeight, maxWidth, maxHeight);
		
		lblFirstName = new Label(firstName);
		lblLastName = new Label(lastName);;
		lblEmail = new Label(email);;
		lblUsername = new Label(username);;
		lblPassword = new Label(password);;
	}
	
	public Scene instantiateScene() {
		VBox homeScreenVBox = new VBox();
		homeScreenVBox.getChildren().addAll(lblFirstName, lblLastName, lblEmail, lblUsername, lblPassword);
		Scene homeScreenScene = new Scene(homeScreenVBox, initialWidth, initialHeight);
		homeScreenScene.getStylesheets().add("com/jchat/style/base_theme.css");
		return homeScreenScene;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogout() {
		return logout;
	}

	public void setLogout(String logout) {
		this.logout = logout;
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

	public Button getBtnLogout() {
		return btnLogout;
	}

	public void setBtnLogout(Button btnLogout) {
		this.btnLogout = btnLogout;
	}
	
	
	
}