package com.janek.todoapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "TASKS_GROUPS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Task group's description must be not blank!")
    private String description;
    private boolean done;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "group")
    private Set<Task> taskList;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
