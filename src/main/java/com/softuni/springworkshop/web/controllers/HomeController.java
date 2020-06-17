package com.softuni.springworkshop.web.controllers;

import com.softuni.springworkshop.service.ExerciseService;
import com.softuni.springworkshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    private final ExerciseService exerciseService;
    private final UserService userService;

    public HomeController(ExerciseService exerciseService, UserService userService) {
        this.exerciseService = exerciseService;
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView getIndex() {
        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView getHome(ModelAndView modelAndView) {
        modelAndView.addObject("activeExercises",
                this.exerciseService.getAllActiveExercises());

        modelAndView.addObject("topStudents",
                this.userService.getTopThreeStudents());

        modelAndView.setViewName("home");
        return modelAndView;
    }
}
