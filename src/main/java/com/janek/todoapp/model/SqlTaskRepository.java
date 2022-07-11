package com.janek.todoapp.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SqlTaskRepository extends JpaRepository<Task, Integer>, TaskRepository {

    @Override
    @Query("SELECT T FROM Task T WHERE T.done = :done")
    List<Task> findByDone(boolean done);
}
