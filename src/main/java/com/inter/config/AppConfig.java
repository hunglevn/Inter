package com.inter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Value(value = "${feedback.topic.name}")
	private String feedbackTopicName;

	public String getFeedbackTopicName() {
		return feedbackTopicName;
	}
}
