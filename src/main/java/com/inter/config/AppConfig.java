package com.inter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Get values of application config;
 * 
 * @author Kevin
 *
 */
@Configuration
public class AppConfig {
	@Value(value = "${feedback.topic.name}")
	private String feedbackTopicName;

	@Value(value = "${preconfigure.username}")
	private String preconfigureUsername;

	@Value(value = "${preconfigure.password}")
	private String preconfigurePassword;

	@Value(value = "${kafka.bootstrapAddress}")
	private String kafkaBootstrapAddress;

	@Value(value = "${feedback.topic.groupid}")
	private String feedbackTopicGroupid;

	public String getFeedbackTopicName() {
		return feedbackTopicName;
	}

	public String getPreconfigureUsername() {
		return preconfigureUsername;
	}

	public String getPreconfigurePassword() {
		return preconfigurePassword;
	}

	public String getKafkaBootstrapAddress() {
		return kafkaBootstrapAddress;
	}

	public String getFeedbackTopicGroupid() {
		return feedbackTopicGroupid;
	}

}
