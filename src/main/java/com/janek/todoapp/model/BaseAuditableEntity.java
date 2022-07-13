package com.janek.todoapp.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class BaseAuditableEntity {
    private LocalDateTime createdOn;
    private LocalDateTime updateOn;

    @PrePersist
    void prePersist() {
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    void preMerge() {
        updateOn = LocalDateTime.now();
    }

}
