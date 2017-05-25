package com.theironyard.charlotte.controllers;

import com.theironyard.charlotte.repositories.AuthorityRepository;
import com.theironyard.charlotte.repositories.UserRepository;
import com.theironyard.charlotte.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;

@Controller
public class HomeController {
    UserRepository users;
    AuthorityRepository auth;

    UserService userService;

    public HomeController(UserRepository users, AuthorityRepository auth, UserService userService) {
        this.users = users;
        this.auth = auth;
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        if (users.count() == 0) {
            userService.createUser("Steve", "test");
        }
    }


    // standard request mappings for home
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    // and hello
    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }



    @RequestMapping(path = "/admin-page", method = RequestMethod.GET)
    public String adminPage() {
        return "admin";
    }
}
