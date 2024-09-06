package com.todo.task_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TaskConfiguration {
    @Bean
    public RestTemplate restTemplate() {return new RestTemplate();}
}
