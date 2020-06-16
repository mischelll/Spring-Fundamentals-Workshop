package com.softuni.springworkshop.web.models;

import lombok.NonNull;

import javax.validation.constraints.Pattern;

public class HomeworkAddModel {
    private String exercise;
    private String git;

    public HomeworkAddModel(String exercise, String git) {
        this.exercise = exercise;
        this.git = git;
    }

    public HomeworkAddModel() {
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
