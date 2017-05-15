package com.theironyard.charlotte.controllers;

import com.theironyard.charlotte.entities.User;
import com.theironyard.charlotte.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// RestController here
// where normally we have just @Controller.
// this indicates that this is a controller that handles
// json requests.
@RestController
public class AngularSpringController {
    // autowire users repository to save/retrieve data about users
    @Autowired
    UserRepository users;


    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public List<User> getUsers() {
        // spring will turn this into json
        return (List<User>) users.findAll();
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    // Get a `User` object from the request body.
    // "what I expect from the request body is a json representation
    // of a user
    public void addUser(@RequestBody User user) {
        // simply save the information to the repository
        // user has NO id, so a new object will be created
        users.save(user);
    }

    // RequestMethod.PUT means we're updating an existing object
    // difference between post and put is often that post will create
    // a new object while put will update an existing one
    @RequestMapping(path = "/user", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {
        // in THIS method, the user will HAVE an id.
        // when we save this user, hibernate will find
        // the object in the table with this id
        // and overwrite its values with this user object
        users.save(user);
    }

    // will accept DELETE requests to "/user/1", or "/user/3", etc.
    @RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") int id) {
        // Spark equivalent:
        // String idString = request.queryParams("id");

        // .delete takes in a int ID, deletes
        // the user with that ID.
        users.delete(id);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") int id) {
        return users.findOne(id);
    }
//    What we're used to seeing:
//    @RequestMapping(path = "/user", method = RequestMethod.GET)
//    public String getUsersPage(Model model) {
//       List<User> users = (List<User>) users.findAll();
//       model.addAttribute("users", users);
//       return "home";
//    }
}
