package com.softuni.springworkshop.web.controllers;

import com.softuni.springworkshop.service.ExerciseService;
import com.softuni.springworkshop.service.HomeworkService;
import com.softuni.springworkshop.service.models.HomeworkAddServiceModel;
import com.softuni.springworkshop.web.models.HomeworkAddModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/homework")
public class HomeworkController {
    private final ModelMapper mapper;
    private final HomeworkService homeworkService;
    private final ExerciseService exerciseService;

    public HomeworkController(ModelMapper mapper, HomeworkService homeworkService, ExerciseService exerciseService) {
        this.mapper = mapper;
        this.homeworkService = homeworkService;
        this.exerciseService = exerciseService;
    }

    @GetMapping("/add")
    public ModelAndView getAddHomework(@Valid @ModelAttribute("homework")
                                               HomeworkAddModel homework,
                                       ModelAndView modelAndView) {
        modelAndView.addObject("homework", homework);
        modelAndView.addObject("exercises",this.exerciseService.getAllExercises());
        modelAndView.setViewName("homework-add");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView getAddHomeworkConfirm(@Valid @ModelAttribute("homework")
                                                      HomeworkAddModel homework,
                                              BindingResult bindingResult,
                                              Principal principal,
                                              RedirectAttributes redirectAttributes,
                                              ModelAndView modelAndView) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("homework", homework);
            modelAndView.setViewName("redirect:/homework/add");
        }else {
            String userName = principal.getName();
            HomeworkAddServiceModel map = this.mapper.map(homework, HomeworkAddServiceModel.class);
            this.homeworkService.addHomework(map,userName);
            modelAndView.setViewName("redirect:/home");
        }


        return modelAndView;
    }


}
