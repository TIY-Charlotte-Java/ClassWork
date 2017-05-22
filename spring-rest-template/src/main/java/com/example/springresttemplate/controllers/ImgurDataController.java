package com.example.springresttemplate.controllers;

import com.example.springresttemplate.models.ImgurData;
import com.example.springresttemplate.services.ImgurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ImgurDataController {
    // Option 1: Add the @Autowired annotation
    // to your dependency.
//    @Autowired
//    ImgurService imageService;


    // Option 2: Just define the field...
    ImgurService imageService;


    // ..and then use the constructor to set the field.
    // spring will inject this image service for us.
    public ImgurDataController(ImgurService imageService) {
        this.imageService = imageService;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        ImgurData imageData = imageService.getData();

        // take a gander at the image data returned by our service
        model.addAttribute("images", imageData.getImages());
        return "home";
    }
}
