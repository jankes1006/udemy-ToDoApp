package com.janek.todoapp.logic;

import com.janek.todoapp.adapter.SqlProjectRepository;
import com.janek.todoapp.config.TaskConfigurationProperties;
import com.janek.todoapp.model.*;
import com.janek.todoapp.model.projection.GroupReadModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProjectService {
    private final ProjectRepository repository;
    private final TaskGroupRepository taskGroupRepository;
    private TaskConfigurationProperties config;

    public List<Project> readAll(){
        return repository.findAll();
    }

    public Project save(Project toSave) {
        return repository.save(toSave);
    }

    public GroupReadModel createGroup(LocalDateTime deadline, int projectId) throws IllegalAccessException {
        if(config.getTemplate().isAllowMultipleTasks() && taskGroupRepository.existsByDoneIsFalseAndProject_Id(projectId)){
            throw new IllegalAccessException("Only one undone group from project is allowed");
        }
        TaskGroup result = repository.findById(projectId)
                .map(project -> {
                    var taskGroup = new TaskGroup();
                    taskGroup.setDescription(project.getDescription());
                    taskGroup.setTaskList(project.getSteps().stream()
                            .map(step -> new Task(step.getDescription(), deadline.plusDays(step.getDaysToDeadline())))
                            .collect(Collectors.toSet()));
                    return taskGroup;
                }).orElseThrow(() -> new IllegalArgumentException("Project with given id not found"));
        return new GroupReadModel(result);

    }
}
