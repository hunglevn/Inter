package com.inter.kafka.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;

public class FeedbackKafkaConsumer {
    @Value(value = "${feedback.topic.groupid}")
    private String feedbackTopicGroupid;
    
	@KafkaListener(topics = "${feedback.topic.name}", groupId = "${feedback.topic.groupid}", containerFactory = "feedbackKafkaListenerContainerFactory")
    public void listenFeedbackTopic(String message) {
        System.out.println(String.format("Received Messasge in group '%s': %s", feedbackTopicGroupid, message));
    }
}
