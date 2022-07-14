package com.janek.todoapp.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    List<Task> findAll();

    Optional<Task> findById(Integer id);

    Task save(Task entity);

    Page<Task> findAll(Pageable pageable);

    List<Task> findByDone(boolean done);

    boolean existsByDoneIsFalseAndGroup_Id(Integer groupId);

    boolean existsById(int id);

}
