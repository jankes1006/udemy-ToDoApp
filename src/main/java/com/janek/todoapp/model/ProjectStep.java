package com.janek.todoapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "PROJECT_STEPS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Project step description must be not blank!")
    private String description;
    private int daysToDeadline;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
