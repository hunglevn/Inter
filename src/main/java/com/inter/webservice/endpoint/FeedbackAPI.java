package com.inter.webservice.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Kevin
 *
 */
@RestController
@RequestMapping("/api/feedback")
public class FeedbackAPI extends ClientAPI implements IFeedbackAPI {
	
	/**
	 * Read feeding back message from posted data.
	 * Put received message to "FeedingbackTopic" Kafka topic.
	 * Send JSON response result to client.
	 * Sample JSON response:
	 * ....
	 */
	@Override
	@RequestMapping("send")
	public String send(@RequestParam("message")String message) {
		System.out.println("Receive: " + message);
		return message;
	}

}
