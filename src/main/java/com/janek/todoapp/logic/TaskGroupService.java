package com.janek.todoapp.logic;

import com.janek.todoapp.config.TaskConfigurationProperties;
import com.janek.todoapp.model.TaskGroup;
import com.janek.todoapp.model.TaskGroupRepository;
import com.janek.todoapp.model.TaskRepository;
import com.janek.todoapp.model.projection.GroupReadModel;
import com.janek.todoapp.model.projection.GroupWriteModel;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class TaskGroupService {
    private final TaskGroupRepository repository;
    private final TaskRepository taskRepository;

    public GroupReadModel createGroup(GroupWriteModel source){
        TaskGroup result = repository.save(source.toGroup());
        return new GroupReadModel(result);
    }

    public List<GroupReadModel> readAll() {
        return repository.findAll().stream()
                .map(GroupReadModel::new)
                .collect(Collectors.toList());
    }

    public void toggleGroup(int groupId) {
        if(taskRepository.existsByDoneIsFalseAndGroup_Id(groupId)){
            throw new IllegalStateException("Group has undone tasks. Done all the tasks first.");
        }
        TaskGroup result = repository.findById(groupId).orElseThrow(() -> new IllegalArgumentException("TaskGroup with given id not found!"));
        result.setDone(!result.isDone());
    }
}
