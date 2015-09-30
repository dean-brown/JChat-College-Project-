/*
 * Almost there! But will need to refactor this and abstract if im going to make the app bigger!
 * 
 * NOTE I WAS USING JSON-SIMPLE BUT AM NOW USING JSON-JAVA as it seems like an easier implementation to understand
 * 
 * 
 */

package com.jchat.network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import com.jchat.ie.User;


public class NetworkHelper {
	private final String SERVER_ADDRESS = "http://testsecretapp.eu5.org/";
	private final String USER_AGENT = "Mozilla/5.0";
	private String fileName;

	public NetworkHelper(String fileName) {
		this.fileName = fileName;
	}

	public User fetchUserDetailsFromServer(User user) throws Exception {
		System.out.println("Testing 'fetch user data' method");
		String url = SERVER_ADDRESS + fileName;

		// Create the Url & connection objects
		URL urlObject = new URL(url);
		HttpURLConnection httpConnection = (HttpURLConnection) urlObject.openConnection();

		// Creating header request
		httpConnection.setRequestMethod("POST");
		httpConnection.setRequestProperty("User-Agent", USER_AGENT);
		// Not sure if this is needed!
		httpConnection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "username=" + user.getUsername() + "&password=" + user.getPassword();

		// Send the post request
		httpConnection.setDoOutput(true);
		DataOutputStream dataOutputStream = new DataOutputStream(httpConnection.getOutputStream());
		dataOutputStream.writeBytes(urlParameters);
		dataOutputStream.flush();
		dataOutputStream.close();

		// Get the response from the server:
		int responseCode = httpConnection.getResponseCode();
		System.out.println("Posting to: " + url);
		System.out.println("Post Params: " + urlParameters);
		System.out.println("Reponse code: " + responseCode);

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
		String line;
		StringBuffer response = new StringBuffer();

		while ((line = bufferedReader.readLine()) != null) {
			response.append(line);
		}

		bufferedReader.close();

		// Build a user profile based on the returned JSON file
		String jsonResponseString = response.toString();
		JSONObject jsonObject = new JSONObject(jsonResponseString);
		String firstName = jsonObject.getString("firstname");
		String lastName = jsonObject.getString("lastname");
		String email = jsonObject.getString("email");
		String username = jsonObject.getString("username");
		String password = jsonObject.getString("password");
		
		User retrievedUser = new User(firstName, lastName, email, username, password);
		return retrievedUser;

	}
    // TODO - Return true if the creation is successful or false if it failed... Look at how to do this now
	public boolean createUserDataOnServer(User user) throws Exception {
		System.out.println("Testing 'create user data' method");
		String url = SERVER_ADDRESS + "Register.php";

		// Create the Url & connection objects
		URL urlObject = new URL(url);
		HttpURLConnection httpConnection = (HttpURLConnection) urlObject.openConnection();

		// Creating header request
		httpConnection.setRequestMethod("POST");
		httpConnection.setRequestProperty("User-Agent", USER_AGENT);
		// Not sure if this is needed TODO - remove this to see if it still works!
		httpConnection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		
		String urlParameters = "firstname=" + user.getFirstName() + "&lastname=" + user.getLastName() + "&username="
				+ user.getUsername() + "&email=" + user.getEmail() + "&password=" + user.getPassword();

		// Send the post request
		httpConnection.setDoOutput(true);
		DataOutputStream dataOutputStream = new DataOutputStream(httpConnection.getOutputStream());
		dataOutputStream.writeBytes(urlParameters);
		dataOutputStream.flush();
		dataOutputStream.close();

		// Get the response code from the server:
		int responseCode = httpConnection.getResponseCode();
		System.out.println("Posting to: " + url);
		System.out.println("Post Params: " + urlParameters);
		System.out.println("Reponse code: " + responseCode);

		// Read the response from the server
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
		String line;
		StringBuffer response = new StringBuffer();

		while ((line = bufferedReader.readLine()) != null) {
			response.append(line);
		}

		bufferedReader.close();
		
		//TODO - change this so it can determine if the user was created successfully!!
		return true;

	}

}
