/*
 * Might add some network stuff into here, will probably add the vbox creation to this class 
 * also....
 */
package com.jchat.ui;

public abstract class Screen {
	protected String screenTitle;
	protected int initialWidth;
	protected int initialHeight;
	protected int maxWidth;
	protected int maxHeight;
	
	public Screen(String screenTitle, int initialWidth, int initialHeight, int minWidth, int minHeight) {
		this.screenTitle = screenTitle;
		this.initialWidth = initialWidth;
		this.initialHeight = initialHeight;
		this.maxWidth = minWidth;
		this.maxHeight = minHeight;
	}
	
	/*
	 * Might create the VBox here as each subScreen will need a VBox... 
	 * Then let the sub screen deal with adding the labels and buttons. . .  
	 */
	
}
