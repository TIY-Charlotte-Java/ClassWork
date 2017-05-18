package com.theironyard.charlotte.controllers;

import com.theironyard.charlotte.entities.BlogPost;
import com.theironyard.charlotte.repositories.BlogPostRepository;
import com.theironyard.charlotte.services.FooService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ben on 5/17/17.
 */
@Controller
public class IronBlogController {
    FooService service;

    BlogPostRepository blogs;

    // constructor-based dependency injection
    // earlier, with the @Autowired annotation, we were performing
    // field-based injection.
    public IronBlogController(FooService service, BlogPostRepository blogs) {
        this.service = service;
        this.blogs = blogs;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        // finding all the posts in our repo
        Iterable<BlogPost> blogPosts = blogs.findAll();

        // pass data into our template with key "blogposts."
        // the value is all the posts we retrieved from our data
        // layer
        model.addAttribute("blogposts", blogPosts);
        return "home";
    }

    @RequestMapping(path = "/blog-posts/{id}", method = RequestMethod.GET)
    public String displayBlog(Model model) {
        return "post";
    }

}
