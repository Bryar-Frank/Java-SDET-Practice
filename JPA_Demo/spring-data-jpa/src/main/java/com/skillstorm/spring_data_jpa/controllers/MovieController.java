package com.skillstorm.spring_data_jpa.controllers;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.spring_data_jpa.models.Movie;
import com.skillstorm.spring_data_jpa.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService service;
    
    private final Logger logger =  LoggerFactory.getLogger(MovieController.class);
    
    // use dependency injection to get an instance of the MovieRepository
    // Constructor or Setter injection
    public MovieController(MovieService service) {
        this.service = service;
    }  //if you only have one constructor, you don't need @Autowired

    
    @GetMapping("helloworld")
    public String helloworld() {
        return "Hello World!";
    }

    @GetMapping
    public Iterable<Movie> findAll() {
        return service.findAll();
    }

    @GetMapping("/top3")
    public Iterable<Movie> findTop3() {
        return service.findTop3();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findMovieById(@PathVariable int id) {
        Optional<Movie> movie =  service.findById(id);
        if (movie.isPresent()) {
            return ResponseEntity.ok(movie.get());
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addmovie")
    @ResponseStatus(code=HttpStatus.CREATED)
    public Movie addMovie (@RequestBody Movie movie) {
        logger.debug("=============================================");
        logger.debug("POST request to /movies with Movie of " + movie);
        return service.save(movie);
    }
    
    @PutMapping("/{id}")
    public void putMethodName (@PathVariable int id, @RequestBody Movie movie) {
    
    }

    @DeleteMapping("/{id}")
    public void deleteMovie() {

    }
}
