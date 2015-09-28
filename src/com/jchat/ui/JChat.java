/*
 *
 * Student Name: Dean Brown
 * Student Number: 20066915
 * Project Name: JChat
 * Project Description: Chat (IM) client application 
 * 
 * 
 * TODO - Create the methods. Then cut this whole section out of here and paste the rebuild with the methods below!!!!!
 * 
 * TODO - Methods really need to be set up for this class SOME SERIOUS PLANNING IS NEEDED TONIGHT BEFORE THIS GETS TO BIG!!!
 *  
 * TODO - Abstract the network class to allow the definitive details to be stored 
 * in a super class which each element of the network classes can access.
 * 
 * TODO - Set this class up to implement some sort of click handler to pass control to a method with a switch! all the setOnAction events are a massive pain!!!!!
 * 
 * TODO - Test the register screen
 * 
 * TODO - Error handling!
 * 
 */

package com.jchat.ui;

import com.jchat.ie.User;
import com.jchat.network.NetworkHelper;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class JChat extends Application {
	private HomeScreen homeScreen;
	private LoginScreen loginScreen;
	private RegisterScreen registerScreen;
	
	// TODO - After setting up the sqlite database change this to blank 
	boolean isUserLoggedIn = false;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		if(!isUserLoggedIn) {
			/*
			 * If the user is not logged in show them the login screen 
			 * else set up the homescreen based on the users sqlite database info!
			 */
			LoginScreen loginScreen = new LoginScreen("Login", 500, 400, 400, 300); 
			Scene loginScene = loginScreen.instantiateScene();
			primaryStage.setScene(loginScene);
			primaryStage.setTitle(loginScreen.getScreenTitle());
			primaryStage.show();
			
			/*
			 * Create the buttons and their listeners
			 */
			Button btnLogin = loginScreen.getBtnLogin();
			Button btnRegister = loginScreen.getBtnRegister();
			
			btnLogin.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					System.out.println("Logging in. . . ");
					// Create a user
					User loginUser = new User(loginScreen.getTfUsername().getText().toString(),
							loginScreen.getPfPassword().getText().toString());
					
					NetworkHelper loginHelper = new NetworkHelper("FetchUserData.php");
					try {
						User returnedUser = loginHelper.fetchUserDetailsFromServer(loginUser);
						HomeScreen homeScreen = new HomeScreen(returnedUser, "Home", 500, 400, 400, 300); 
						System.out.println("TESTING - "
								+ "\nFirstname: " + returnedUser.getFirstName()
								+ "\nLastname: " + returnedUser.getLastName()
								+ "\nUsername: " + returnedUser.getUsername()
								+ "\nEmail: " + returnedUser.getEmail()
								+ "\nPassword: " + returnedUser.getPassword());
						homeScreen.setFirstName(returnedUser.getFirstName());
						homeScreen.setLastName(returnedUser.getLastName());
						homeScreen.setEmail(returnedUser.getEmail());
						homeScreen.setUsername(returnedUser.getUsername());
						homeScreen.setPassword(returnedUser.getPassword());
						Button btnLogoutButton = homeScreen.getBtnLogout();
						Scene homeScreenScene = homeScreen.instantiateScene();
						primaryStage.setScene(homeScreenScene);
						primaryStage.show();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			});
		
			btnRegister.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					System.out.println("Changing to register page. . . ");
					RegisterScreen registerScreen = new RegisterScreen("Register", 500, 400, 400, 300);
					Scene registerScreenScene = registerScreen.instantiateScene();
					primaryStage.setScene(registerScreenScene);
					primaryStage.show();
					Button btnRegister = registerScreen.getBtnRegister();
					Button btnLogin = registerScreen.getBtnLogin();
					
					// Add click listeners (This will later be changed!)
					btnRegister.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							// Create a network helper to insert data into the database
							NetworkHelper registerHelper = new NetworkHelper("Register.php");
							try {
								// Create a temp user to insert into the database!
								String regUserFirstName = registerScreen.getTfFirstName().getText().toString();
								String regUserLastName = registerScreen.getTfLastName().getText().toString();
								String regUserEmail = registerScreen.getTfEmail().getText().toString();
								String regUserUsername = registerScreen.getTfUsername().getText().toString();
								String regUserPassword = registerScreen.getPfPassword().getText().toString();
								String regUserRepeatPassword = registerScreen.getPfRepeatPassword().getText().toString();
								
								//TODO - This is returning false for some reason!!!!!!!
								if(checkRepeatPassword(regUserPassword, regUserRepeatPassword)) {
									System.out.println("Passwords match");
									// TODO - Insert the password into the database
									User userToReg = new User(regUserFirstName, regUserLastName, regUserEmail, regUserUsername, regUserPassword);
									
									if(registerHelper.createUserDataOnServer(userToReg)) {
										System.out.println("User has been created successfully");
										
									} else {
										System.out.println("Could not create user");
									}
									
									
								} else {
									System.out.println("Passwords do not match!!!!!");
									// Display a notification to the user!
									registerScreen.getLblErrorWithRegistration().setText(registerScreen.getPASSWORDS_NOT_MATCH());
								}
								
								// Called if the registration fails for some reason!
							}catch(Exception e) {
								e.printStackTrace();
							}
							
						}
					});
				}
			});
			
		} else {
			/*TODO - Set up a local database to store the users details
			and then pull them from the database if the user checks 
			remember me!*/
		}
		
	}
	
	
	
	/*
	 * 
	 * # Create methods to allow for screen changes here. . . 
	 * CreateLoginScreen()
	 * CreateRegisterScreen()
	 * CreateHomescreen()
	 * 
	 * # Then for User stuff
	 * AuthenticateUserLogin()
	 * CreateNewUser()
	 * 
	 * 
	 * # For way later:
	 * Set up the Chat table and the Message table!
	 * 
	 * 
	 */
	
	// Creates the HomeScreenScene:
	private void CreateHomeScreen() {
		
		
	}
	// Creates the LoginScreenScene:
	private void CreateLoginScreen() {
		
	}
 	
	// Creates the RegisterScreenScene:
	private void CreateRegisterScreen() {
		
	}
	
	
	
	/*
	 * Returns true if the passwords match or false if they do not match!
	 */
	public boolean checkRepeatPassword(String password, String repeatPassword) {
		System.out.println("Password: " + password + "\n" + "Repeat Password: " + repeatPassword);
		if(password.equals(repeatPassword)) {
			return true;
		} else {
			return false;
		}
	}

}
