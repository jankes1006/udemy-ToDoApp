package com.janek.todoapp.controller;

import com.janek.todoapp.model.Task;
import com.janek.todoapp.model.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RepositoryRestController
@RequiredArgsConstructor
@Slf4j
class TaskController {
    private final TaskRepository repository;

    @GetMapping(path = "/tasks", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Task>> readAllTasks() {
        log.warn("Exposing all the task!");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(path = "/tasks")
    ResponseEntity<Page<Task>> readAllTasks(Pageable pageable) {
        log.warn("Exposing all the task!");
        return ResponseEntity.ok(repository.findAll(pageable));
    }
}
