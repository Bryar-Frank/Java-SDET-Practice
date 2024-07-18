package com.skillstorm.spring_mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.spring_mvc.dtos.UserDto;
import com.skillstorm.spring_mvc.models.User;
import com.skillstorm.spring_mvc.services.UserService;

/*
 * Controller vs Rest Controller
 * 
 *      RestController  implicity add @ResponseBody to every method in the class
 *      Controller      you have to include it on every method
 *      @ResponseBody   will tell the controller that the object return is serialized into the JSON insode
 *                      the body of the HTTP response
 *      @RequestMapping will allow us to map all our requests to a specific path
 */

// localhost:8080/users/helloworld will return string "Hello World!"

@RestController  //stereotype annotation for @Component
@RequestMapping("/users")  //everytime an http request comes to "/users", it will be sent to this controller
public class UserController {
    @Autowired          //will ask SpringBoot to give us this service
    UserService service;

    /*
     * GET      - retrieves data *TODO* most likely in the database?
     * POST     - creates data
     * PUT      - updates data
     * DELETE   - deletes data
     */
    @RequestMapping("/helloworld")
    public String helloWorld() {
        return "Hello World!";
    }

    /*
     * GetMapping is an HTTP GET Request
     *      same as @RequestMapping("path", method=RequestMethod.GET)
     */
    @GetMapping  //if you don't specify ("path") then it will default to "/users"
    public List<UserDto> findAllUsers() {
        return service.findAllUsers();
    }

    /*
     * @RequestParam
     *      finds the data for the parameter in the url path
     *      /users/firstname?firstName=[data]
     */

    @GetMapping("/first_name")
    public List<User> findUsersByFirstName(@RequestParam String firstName) {
        return service.findUsersByFirstName(firstName);
    }

    @GetMapping("/user/{id}")
    public User findById(@PathVariable long id) {
        return service.findById(id);
    }

    /*
     * PostMapping      - typically used to creat data
     * 
     * @ResponseEntity  - object that gives you more control over your http response
     *                  - modify headers, status code, etc.
     * 
     * @RequestBody     - looks for data in the body of the request
     *                  - deserializes JSON to java object
     */

    @PostMapping("/createuser")
    public ResponseEntity<List<User>> createUser(@RequestBody User user) {
        List<User> createdUsers = service.createUser(user);

        return new ResponseEntity<List<User>>(createdUsers, HttpStatus.CREATED);
    }

    @PutMapping("/updateuser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user) {
        User upadateddUser = service.updateUser(id, user);

        return new ResponseEntity<User>(upadateddUser, HttpStatus.OK);
    }

    // @DeleteMapping("/user/{id}")
    // public ResponseEntity<User> deleteUser(@PathVariable long id, @RequestBody User user) {
    //     service.deleteUser(id, user);

    //     return new ResponseEntity<User>(HttpStatus.NO_CONTENT); // sets the status code to 204 - No Content
    // }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable long id) {
        service.deleteUser(id);

        return new ResponseEntity<User>(HttpStatus.NO_CONTENT); // sets the status code to 204 - No Content
    }
}
