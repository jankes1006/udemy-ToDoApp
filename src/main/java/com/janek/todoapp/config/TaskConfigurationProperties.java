package com.janek.todoapp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("task")
public class TaskConfigurationProperties {
    private Template template;

    @Data
    public static class Template {
        private boolean allowMultipleTasks;
    }
}
