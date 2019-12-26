package com.inter.kafka.producer;

public interface IFeedbackKafkaProducer {
	public void sendMessage(String title, String message);
}
