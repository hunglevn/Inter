package com.inter.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.inter.kafka.bean.Feedback;

public class FeedbackKafkaProducer {

    @Autowired
    private KafkaTemplate<String, Feedback> feedbackKafkaTemplate;

    @Value(value = "${message.topic.name}")
    private String topicName;

    @Value(value = "${partitioned.topic.name}")
    private String partionedTopicName;

    @Value(value = "${filtered.topic.name}")
    private String filteredTopicName;

    @Value(value = "${greeting.topic.name}")
    private String greetingTopicName;

    public void sendMessage(String title, String message) {
        Feedback feedback = new Feedback(title, message);
        ListenableFuture<SendResult<String, Feedback>> future = feedbackKafkaTemplate.send(topicName, feedback);
        
        future.addCallback(new ListenableFutureCallback<SendResult<String, Feedback>>() {

            @Override
            public void onSuccess(SendResult<String, Feedback> result) {
                System.out.println("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            }
        });
    }

}
