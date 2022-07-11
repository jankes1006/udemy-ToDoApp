package com.janek.todoapp.controller;

import com.janek.todoapp.config.TaskConfigurationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
@RequiredArgsConstructor
public class InfoController {

    private final DataSourceProperties dataSource;
    private final TaskConfigurationProperties configurationProperties;

//    Na szybko tak mozna
//    @Value("${spring.datasource.url}")
//    private String url;

    @GetMapping("/url")
    String url() {
        return dataSource.getUrl();
    }

    @GetMapping("/prop")
    Boolean myProp() {
        return configurationProperties.getTemplate().isAllowMultipleTasks();
    }
}
