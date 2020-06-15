package com.softuni.springworkshop.service.models;

import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class ExerciseAddServiceModel {
    private String name;
    private LocalDateTime startedOn;
    private LocalDateTime dueDate;

    public ExerciseAddServiceModel() {
    }

    public ExerciseAddServiceModel(String name, LocalDateTime startedOn, LocalDateTime dueDate) {
        this.name = name;
        this.startedOn = startedOn;
        this.dueDate = dueDate;
    }

    @NonNull
    @Size(min = 3,message = "Exercise name length must be more than 2 characters")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @PastOrPresent(message = "The date cannot be in the future")
    public LocalDateTime getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(LocalDateTime startedOn) {
        this.startedOn = startedOn;
    }

    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "The date cannot be in the past")
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
