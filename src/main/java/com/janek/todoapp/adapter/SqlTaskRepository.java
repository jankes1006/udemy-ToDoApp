package com.janek.todoapp.adapter;

import com.janek.todoapp.model.Task;
import com.janek.todoapp.model.TaskRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SqlTaskRepository extends JpaRepository<Task, Integer>, TaskRepository {

    @Override
    @Query("SELECT T FROM Task T WHERE T.done = :done")
    List<Task> findByDone(boolean done);

    @Override
    boolean existsByDoneIsFalseAndGroup_Id(Integer groupId);

}
