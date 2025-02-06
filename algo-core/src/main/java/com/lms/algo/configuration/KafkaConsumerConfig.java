package com.lms.algo.configuration;

import com.lms.algo.model.dto.ReceiveSubmittedTestCaseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
@EnableKafka
@RequiredArgsConstructor
public class KafkaConsumerConfig {

    private final KafkaConfigurationProperties kafkaConfigurationProperties;
    private final static Long DEFAULT_POLL_TIMEOUT = 3000L;

    @Bean
    public ConsumerFactory<String, ReceiveSubmittedTestCaseDto> codeJudgeConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(kafkaConfigurationProperties.getCodeJudgeProperties().buildConsumerProperties());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<?, ?> codeJudgeListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, ReceiveSubmittedTestCaseDto> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(codeJudgeConsumerFactory());
        var concurrency = kafkaConfigurationProperties.getCodeJudgeProperties().getListener().getConcurrency();
        factory.setConcurrency(concurrency);
        factory.getContainerProperties().setPollTimeout(DEFAULT_POLL_TIMEOUT);
        return factory;
    }
}