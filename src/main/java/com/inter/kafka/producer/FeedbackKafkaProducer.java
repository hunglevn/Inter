package com.inter.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.inter.config.AppConfig;
import com.inter.kafka.bean.Feedback;

/**
 * Produce message on "FeedbackTopic" kafka topic
 * 
 * @author Kevin
 *
 */
@Service
public class FeedbackKafkaProducer implements IFeedbackKafkaProducer {
	@Autowired
    private AppConfig appConfig;
	
    @Autowired
    private KafkaTemplate<String, Feedback> feedbackKafkaTemplate;

    public void sendMessage(String title, String message) {
        Feedback feedback = new Feedback(title, message);
        ListenableFuture<SendResult<String, Feedback>> future = feedbackKafkaTemplate.send(appConfig.getFeedbackTopicName(), feedback);
        
        future.addCallback(new ListenableFutureCallback<SendResult<String, Feedback>>() {

            @Override
            public void onSuccess(SendResult<String, Feedback> result) {
                System.out.println("Sent message=[" + result.getProducerRecord().value().toString() + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            }
        });
    }

}
