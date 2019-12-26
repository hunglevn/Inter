package com.inter.kafka.topic;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inter.config.AppConfig;

@Configuration
public class KafkaTopicConfig {
	@Autowired
    private AppConfig appConfig;
	
    @Bean
    public NewTopic feedbackTopic() {
         return new NewTopic(appConfig.getFeedbackTopicName(), 1, (short) 1);
    }
}
