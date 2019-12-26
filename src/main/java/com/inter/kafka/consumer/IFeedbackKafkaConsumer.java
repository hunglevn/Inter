package com.inter.kafka.consumer;

import com.inter.kafka.bean.Feedback;

/**
 * Handle incoming feedback message
 * @author Kevin
 *
 */
public interface IFeedbackKafkaConsumer {
	public void listenFeedbackTopic(Feedback feedback);
}
