/*
 *
 * Student Name: Dean Brown
 * Student Number: 20066915
 * Project Name: JChat
 * Project Description: Chat application 
 * 
 * TODO - Home screen loads but with the wrong details!
 * 
 * TODO - Create methods in this class to display the homescreen, 
 * the login screen and the register screen rather than repeating the same code
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
	// Set to true to test the loginSCreen (Change to to black afterwards!)
	boolean isUserLoggedIn = false;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		if(!isUserLoggedIn) {
			/*
			 * If the user is not logged in show them the login screen 
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
						//TODO - Create the homescreen
						User returnedUser = accountHelper.fetchUserDetailsFromServer(loginUser);
						HomeScreen homeScreen = new HomeScreen(returnedUser, "Home", 500, 400, 400, 300); 
						homeScreen.setFirstName(returnedUser.getFirstName());
						homeScreen.setLastName(returnedUser.getLastName());
						homeScreen.setEmail(returnedUser.getEmail());
						homeScreen.setUsername(returnedUser.getUsername());
						homeScreen.setPassword(returnedUser.getPassword());
						Scene homeScreenScene = homeScreen.instantiateScene();
						primaryStage.setScene(homeScreenScene);
						primaryStage.show();
						Button btnLogoutButton = homeScreen.getBtnLogout();
						// TODO - Add a Event listener to the Logout button!
						
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			});
		
			btnRegister.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					System.out.println("Changing to register page. . . ");
					// TODO - Set up the registration Screen!
				}
			});
			
		} else {
			/*TODO - Set up a local database to store the users details
			and then pull them from the database if the user checks 
			remember me!*/
		}
		
	}

}
