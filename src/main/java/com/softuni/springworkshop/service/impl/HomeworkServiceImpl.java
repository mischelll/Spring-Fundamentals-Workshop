package com.softuni.springworkshop.service.impl;

import com.softuni.springworkshop.dao.entities.Exercise;
import com.softuni.springworkshop.dao.entities.Homework;
import com.softuni.springworkshop.dao.entities.User;
import com.softuni.springworkshop.dao.repositories.HomeworkRepository;
import com.softuni.springworkshop.service.ExerciseService;
import com.softuni.springworkshop.service.HomeworkService;
import com.softuni.springworkshop.service.UserService;
import com.softuni.springworkshop.service.models.HomeworkAddServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HomeworkServiceImpl implements HomeworkService {
    private final HomeworkRepository homeworkRepository;
    private final ModelMapper mapper;
    private final ExerciseService exerciseService;
    private final UserService userService;

    public HomeworkServiceImpl(HomeworkRepository homeworkRepository, ModelMapper mapper, ExerciseService exerciseService, UserService userService) {
        this.homeworkRepository = homeworkRepository;
        this.mapper = mapper;
        this.exerciseService = exerciseService;
        this.userService = userService;
    }

    @Override
    public HomeworkAddServiceModel addHomework(HomeworkAddServiceModel homework, String userName) {
        Exercise exerciseServiceByName = this.exerciseService.findByName(homework.getExercise());
        UserDetails userByUsername = this.userService.loadUserByUsername(userName);
        Homework homeworkMap = this.mapper.map(homework, Homework.class);

        homeworkMap.setAddedOn(LocalDateTime.now());
        homeworkMap.setExercise(exerciseServiceByName);
        homeworkMap.setAuthor((User) userByUsername);
        homeworkMap.setGitAddress(homework.getGit());
        this.homeworkRepository.saveAndFlush(homeworkMap);

        return homework;
    }
}
