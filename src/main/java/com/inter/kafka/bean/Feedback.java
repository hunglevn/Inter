package com.inter.kafka.bean;

/**
 * Bean object to serialize/deserialize feedback message.
 * @author Kevin
 *
 */
public class Feedback {
    private String message;
    private String title;

    public Feedback() {

    }

	public Feedback(String title, String message) {
		super();
		this.title = title;
		this.message = message;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	@Override
    public String toString() {
        return message + ", " + title + "!";
    }
}
