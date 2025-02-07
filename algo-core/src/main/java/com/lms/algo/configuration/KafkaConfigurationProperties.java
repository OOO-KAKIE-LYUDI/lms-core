package com.lms.algo.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties
@ConfigurationProperties(prefix = "spring.kafka.multiple")
@Configuration
@Getter
@Setter
public class KafkaConfigurationProperties {

    private CodeJudgeProperties codeJudgeProperties;

    @Getter
    @Setter
    public static class CodeJudgeProperties {
        private String bootstrapServers;
        private String templateDefaultTopic;
        private Listener listener;
        private Consumer consumer;

        @Getter
        @Setter
        public static class Listener {
            private int concurrency;
        }

        @Getter
        @Setter
        public static class Consumer {
            private String groupId;
            private String autoOffsetReset;
            private String keyDeserializer;
            private String valueDeserializer;
        }
    }
}

