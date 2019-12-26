package com.inter.kafka.consumer;

import com.inter.kafka.bean.Feedback;

public interface IFeedbackKafkaConsumer {
	public void listenFeedbackTopic(Feedback feedback);
}
