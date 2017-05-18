package com.theironyard.charlotte.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ben on 5/17/17.
 */
@Controller
public class IronBlogController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }

}
