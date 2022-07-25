package com.janek.todoapp.model.projection;

import com.janek.todoapp.model.TaskGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupWriteModel {
    private String description;
    private Set<GroupTaskWriteModel> tasks;

    public TaskGroup toGroup(){
        var result = new TaskGroup();
        result.setDescription(description);
        result.setTaskList(
                tasks.stream().map(GroupTaskWriteModel::toTask)
                        .collect(Collectors.toSet())
        );
        return result;
    }
}
