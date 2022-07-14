package com.janek.todoapp.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Embeddable
@Data
class Audit {
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
