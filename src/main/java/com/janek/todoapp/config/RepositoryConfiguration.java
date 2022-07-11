package com.janek.todoapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class RepositoryConfiguration {
    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }
}
