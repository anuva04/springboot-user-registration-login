package com.springboot.userRegistration.controller;

import com.springboot.userRegistration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.userRegistration.model.User;

import javax.validation.Valid;

@Controller
public class AuthenticationController {
    @Autowired
    UserService userService;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login"); // resources/template/login.html
        return modelAndView;
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register"); // resources/template/register.html
        return modelAndView;
    }

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home"); // resources/template/home.html
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap){
        ModelAndView modelAndView = new ModelAndView();
        if(bindingResult.hasErrors()){
            modelAndView.addObject("successMessage", "Please add correct details!");
            modelMap.addAttribute("bindingResult", bindingResult);
        }else if(userService.isUserPresent(user)){
            modelAndView.addObject("successMessage", "User already exists!");
        }else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User registered successfully!");
        }
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("register");
        return modelAndView;
    }
}
