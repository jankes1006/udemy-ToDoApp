package com.janek.todoapp.model.projection;

import com.janek.todoapp.model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupTaskReadModel {
    private String description;
    private boolean done;

    public GroupTaskReadModel(Task source){
        description = source.getDescription();
        done = source.isDone();
    }
}
