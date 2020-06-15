package com.softuni.springworkshop.service;

import com.softuni.springworkshop.service.models.ExerciseAddServiceModel;
import com.softuni.springworkshop.web.models.ExerciseAddModel;

public interface ExerciseService {
    ExerciseAddServiceModel createExercise(ExerciseAddServiceModel exerciseAdd);
}
