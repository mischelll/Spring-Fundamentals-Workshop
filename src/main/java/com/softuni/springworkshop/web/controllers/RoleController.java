package com.softuni.springworkshop.web.controllers;

import com.softuni.springworkshop.service.RoleService;
import com.softuni.springworkshop.service.UserService;
import com.softuni.springworkshop.web.models.RoleAddModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;
    private final UserService userService;

    public RoleController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/add")
    public ModelAndView getRoleAdd(Model model) {
        model.addAttribute("usernames", this.userService.getUsernames());
        return new ModelAndView("role-add");
    }

    @PostMapping("/add")
    public ModelAndView getRoleAddConfirm(@ModelAttribute("roleAdd") RoleAddModel roleAdd, ModelAndView modelAndView) {

        modelAndView.setViewName("redirect:/home");
        this.userService.changeRole(roleAdd);
        return modelAndView;
    }
}
