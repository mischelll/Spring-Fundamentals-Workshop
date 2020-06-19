package com.softuni.springworkshop.web.controllers;

import com.softuni.springworkshop.service.ExerciseService;
import com.softuni.springworkshop.service.models.ExerciseAddServiceModel;
import com.softuni.springworkshop.web.models.ExerciseAddModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/exercises")
public class ExerciseController {
    private static final String REDIRECT_EXERCISE_ADD = "redirect:/exercises/add";
    private final ModelMapper mapper;
    private final ExerciseService exerciseService;

    public ExerciseController(ModelMapper mapper, ExerciseService exerciseService) {
        this.mapper = mapper;
        this.exerciseService = exerciseService;
    }

    @GetMapping("/add")
    public ModelAndView getAddExercise(@Valid @ModelAttribute("exerciseAdd") ExerciseAddModel exerciseAdd,
                                       BindingResult bindingResult) {
        return new ModelAndView("exercise-add");
    }

    @PostMapping("/add")
    public ModelAndView getAddExerciseConfirm(@Valid @ModelAttribute("exerciseAdd") ExerciseAddModel exerciseAdd,
                                              BindingResult bindingResult,
                                              RedirectAttributes redirectAttributes,
                                              ModelAndView model) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("exerciseAdd", exerciseAdd);
            model.setViewName(REDIRECT_EXERCISE_ADD);
        } else {
            ExerciseAddServiceModel exerciseAddServiceModel = this.exerciseService
                    .createExercise(this.mapper.map(exerciseAdd, ExerciseAddServiceModel.class));

            if (exerciseAddServiceModel == null) {
                //TODO throw error if exercise exists
                model.setViewName(REDIRECT_EXERCISE_ADD);
            } else {
                model.setViewName(REDIRECT_EXERCISE_ADD);
            }
        }

        return model;
    }
}
