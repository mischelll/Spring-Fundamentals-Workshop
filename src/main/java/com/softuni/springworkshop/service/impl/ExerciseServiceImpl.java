package com.softuni.springworkshop.service.impl;

import com.softuni.springworkshop.dao.entities.Exercise;
import com.softuni.springworkshop.dao.repositories.ExerciseRepository;
import com.softuni.springworkshop.service.ExerciseService;
import com.softuni.springworkshop.service.models.ExerciseAddServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private final ModelMapper mapper;
    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ModelMapper mapper, ExerciseRepository exerciseRepository) {
        this.mapper = mapper;
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public ExerciseAddServiceModel createExercise(ExerciseAddServiceModel exerciseAdd) {
        if (this.exerciseRepository.findByName(exerciseAdd.getName()) != null) {
            return null;
        }
        Exercise exercise = this.mapper.map(exerciseAdd, Exercise.class);

        this.exerciseRepository.saveAndFlush(exercise);

        return this.mapper.map(exercise, ExerciseAddServiceModel.class);
    }

    @Override
    public List<String> getAllExercises() {
        return this.exerciseRepository
                .findAll()
                .stream()
                .map(Exercise::getName)
                .collect(Collectors.toList());
    }

    @Override
    public Exercise findByName(String name) {
        return this.exerciseRepository.findByName(name);
    }
}
