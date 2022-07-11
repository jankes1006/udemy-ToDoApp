package com.janek.todoapp.controller;

import com.janek.todoapp.model.Task;
import com.janek.todoapp.model.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/tasks")
class TaskController {
    private final TaskRepository repository;

    @GetMapping(params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Task>> readAllTasks() {
        log.warn("Exposing all the task!");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping
    ResponseEntity<Page<Task>> readAllTasks(Pageable pageable) {
        log.warn("Exposing all the task!");
        return ResponseEntity.ok(repository.findAll(pageable));
    }

    @PutMapping("/{id}")
    ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody @Valid Task toUpdate) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        toUpdate.setId(id);
        repository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    ResponseEntity<Task> updateTask(@PathVariable int id) {
        return repository.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<Task> createTask(@RequestBody @Valid Task task) {
        Task result = repository.save(task);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

}
