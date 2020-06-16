package com.softuni.springworkshop.service.models;

import lombok.NonNull;

import javax.validation.constraints.Pattern;

public class HomeworkAddServiceModel {
    private String exercise;
    private String git;

    public HomeworkAddServiceModel(String exercise, String git) {
        this.exercise = exercise;
        this.git = git;
    }

    public HomeworkAddServiceModel() {
    }

    @NonNull
    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    @NonNull
    @Pattern(regexp ="https://github.com/.+/.+",message = "Enter git address following this pattern")
    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }
}
