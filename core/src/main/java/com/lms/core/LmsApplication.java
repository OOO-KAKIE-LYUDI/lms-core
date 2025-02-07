package com.lms.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@ComponentScan(basePackages = {"com.lms.auth", "com.lms.core", "com.lms.file", "com.lms.algo"})
@EntityScan(basePackages = {"com.lms.core.model.entity", "com.lms.auth.model.entity", "com.lms.algo.model.entity"})
@EnableJpaRepositories(basePackages = {"com.lms.core.repository", "com.lms.auth.repository", "com.lms.algo.repository"})
@EnableFeignClients(basePackages = {"com.lms.algo.feign"})
@EnableKafka
public class LmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(LmsApplication.class, args);
    }
}
