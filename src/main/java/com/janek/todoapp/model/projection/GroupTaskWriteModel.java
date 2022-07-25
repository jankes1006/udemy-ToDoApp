package com.janek.todoapp.model.projection;

import com.janek.todoapp.model.Task;
import com.janek.todoapp.model.TaskGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupTaskWriteModel {
    private String description;
    private LocalDateTime deadline;

    public Task toTask(){
        return new Task(description, deadline);
    }
}
