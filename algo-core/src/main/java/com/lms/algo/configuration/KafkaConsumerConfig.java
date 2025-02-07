package com.lms.algo.configuration;

import com.lms.algo.model.dto.ReceiveSubmittedTestCaseDto;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties(KafkaConfigurationProperties.class)
@EnableKafka
@RequiredArgsConstructor
public class KafkaConsumerConfig {

    private final KafkaConfigurationProperties kafkaConfigurationProperties;
    private static final Long DEFAULT_POLL_TIMEOUT = 3000L;

    @Bean
    public ConsumerFactory<String, ReceiveSubmittedTestCaseDto> codeJudgeConsumerFactory() {
        Map<String, Object> consumerProps = new HashMap<>();
        consumerProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfigurationProperties.getCodeJudgeProperties().getBootstrapServers());
        consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaConfigurationProperties.getCodeJudgeProperties().getConsumer().getGroupId());
        consumerProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, kafkaConfigurationProperties.getCodeJudgeProperties().getConsumer().getAutoOffsetReset());
        consumerProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, kafkaConfigurationProperties.getCodeJudgeProperties().getConsumer().getKeyDeserializer());
        consumerProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, kafkaConfigurationProperties.getCodeJudgeProperties().getConsumer().getValueDeserializer());

        return new DefaultKafkaConsumerFactory<>(consumerProps);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<?, ?> codeJudgeListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, ReceiveSubmittedTestCaseDto> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(codeJudgeConsumerFactory());
        factory.setConcurrency(kafkaConfigurationProperties.getCodeJudgeProperties().getListener().getConcurrency());
        factory.getContainerProperties().setPollTimeout(DEFAULT_POLL_TIMEOUT);
        return factory;
    }
}
