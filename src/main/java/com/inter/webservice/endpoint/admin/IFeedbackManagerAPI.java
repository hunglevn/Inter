package com.inter.webservice.endpoint.admin;

/**
 * 
 * @author Kevin
 *
 */
public interface IFeedbackManagerAPI {
	/**
	 * Search feeding back message from Inter system.
	 * @param keyword
	 * @return
	 */
	public String search(String keyword);

}
