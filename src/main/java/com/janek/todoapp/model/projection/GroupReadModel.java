package com.janek.todoapp.model.projection;

import com.janek.todoapp.model.Task;
import com.janek.todoapp.model.TaskGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupReadModel {
    private String description;
    private LocalDateTime deadline;
    private Set<GroupTaskReadModel> tasks;

    public GroupReadModel(TaskGroup source){
        description = source.getDescription();
        source.getTaskList().stream()
                .map(Task::getDeadline)
                .max(LocalDateTime::compareTo)
                .ifPresent(date -> deadline = date);
        tasks = source.getTaskList().stream()
                .map(GroupTaskReadModel::new)
                .collect(Collectors.toSet());
    }


}
