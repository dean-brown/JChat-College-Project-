package com.jchat.ie;

public class Message {
	private String messageFrom;
	private String messageTo;
	private String message;
	
	public Message(String messageFrom, String messageTo, String message) {
		this.messageFrom = messageFrom;
		this.messageTo = messageTo;
		this.message = message;
	}

	public String getMessageFrom() {
		return messageFrom;
	}

	public void setMessageFrom(String messageFrom) {
		this.messageFrom = messageFrom;
	}

	public String getMessageTo() {
		return messageTo;
	}

	public void setMessageTo(String messageTo) {
		this.messageTo = messageTo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
