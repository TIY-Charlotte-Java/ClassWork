package com.theironyard.charlotte.controllers;

import com.theironyard.charlotte.entities.User;
import com.theironyard.charlotte.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(path = "/new-user", method = RequestMethod.GET)
    public String newUser() {
        return "registration";
    }

    @RequestMapping(path = "/new-user", method = RequestMethod.POST)
    public String newUser(User user, String passwordConfirm, boolean isAdmin) {
        userService.createUser(user.getUsername(), user.getPassword(), passwordConfirm, isAdmin);
        return "redirect:/";
    }
}
