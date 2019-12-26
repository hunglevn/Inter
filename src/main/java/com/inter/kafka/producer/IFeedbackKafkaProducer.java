package com.inter.kafka.producer;

/**
 * Produce message on "FeedbackTopic" kafka topic
 * 
 * @author kevin
 *
 */
public interface IFeedbackKafkaProducer {
	public void sendMessage(String title, String message);
}
