/*
 *
 * Student Name: Dean Brown
 * Student Number: 20066915
 * Project Name: JChat
 * Project Description: Chat (IM) client application 
 *  
 * TODO - Abstract the network class to allow the definitive details to be stored 
 * in a super class which each element of the network classes can access.
 * 
 * TODO - Sort out the register screen and test it
 * 
 * TODO - Set up better error handling
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
					
					NetworkHelper accountHelper = new NetworkHelper("FetchUserData.php");
					try {
						User returnedUser = accountHelper.fetchUserDetailsFromServer(loginUser);
						// TODO - change this to pass in the users details after fetching it from the server
						// TODO - Get the logout button to display and Add a Event listener to the Logout button!
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
				}
			});
			
		} else {
			/*TODO - Set up a local database to store the users details
			and then pull them from the database if the user checks 
			remember me!*/
		}
		
	}

}
