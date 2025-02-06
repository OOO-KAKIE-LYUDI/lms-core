package com.lms.algo.configuration;

import lombok.Getter;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties
@ConfigurationProperties(prefix = "spring.kafka.multiple")
@Configuration
@Getter
public class KafkaConfigurationProperties {

    private KafkaProperties codeJudgeProperties;
}
