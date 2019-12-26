package com.inter.webservice.endpoint;

/**
 * 
 * @author Kevin
 *
 */
public interface IFeedbackAPI {
	/**
	 * Send feeding back message to Inter system.
	 * @param message
	 * @return
	 */
	public String send(String message);
}
