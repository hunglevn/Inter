package com.inter.webservice.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inter.kafka.producer.IFeedbackKafkaProducer;

/**
 * 
 * @author Kevin
 *
 */
@RestController
@RequestMapping("/api/feedback")
public class FeedbackAPI extends ClientAPI implements IFeedbackAPI {
	@Autowired
	private IFeedbackKafkaProducer feedbackKafkaProducer;
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
		logger.info("Start put message to queue.");
		feedbackKafkaProducer.sendMessage("Feedback", message);
		logger.info("Finished put message to queue.");
		return message;
	}

}
