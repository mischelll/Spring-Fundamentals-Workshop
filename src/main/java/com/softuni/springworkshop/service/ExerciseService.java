package com.softuni.springworkshop.service;

import com.softuni.springworkshop.dao.entities.Exercise;
import com.softuni.springworkshop.service.models.ExerciseAddServiceModel;
import com.softuni.springworkshop.web.models.ExerciseAddModel;

import java.util.List;

public interface ExerciseService {
    ExerciseAddServiceModel createExercise(ExerciseAddServiceModel exerciseAdd);

    List<String> getAllExercises();

    Exercise findByName(String name);
}
