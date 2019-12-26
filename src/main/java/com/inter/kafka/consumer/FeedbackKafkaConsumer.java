package com.inter.kafka.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.inter.kafka.bean.Feedback;

/**
 * Listen incoming feedback messages.
 * Store received message into MySQL DB
 * 
 * @author Kevin
 *
 */
@Service
public class FeedbackKafkaConsumer implements IFeedbackKafkaConsumer {
    @Value(value = "${feedback.topic.groupid}")
    private String feedbackTopicGroupid;

    @KafkaListener(topics = "${feedback.topic.name}", groupId = "${feedback.topic.groupid}", containerFactory = "feedbackKafkaListenerContainerFactory")
    public void listenFeedbackTopic(Feedback feedback) {
        System.out.println(String.format("Received Messasge in group '%s': %s", feedbackTopicGroupid, feedback.toString()));
    }
}
