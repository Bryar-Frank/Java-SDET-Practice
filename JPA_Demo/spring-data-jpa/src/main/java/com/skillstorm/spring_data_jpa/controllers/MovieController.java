package com.skillstorm.spring_data_jpa.controllers;


import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.spring_data_jpa.models.Movie;
import com.skillstorm.spring_data_jpa.repositories.MovieRepository;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieRepository repo;

    // use dependency injection to get an instance of the MovieRepository
    // Constructor or Setter injection
    public MovieController(MovieRepository repo) {
        this.repo = repo;
    }  //if you only have one constructor, you don't need @Autowired

    
    @GetMapping("helloworld")
    public String helloworld() {
        return "Hello World!";
    }

    @GetMapping
    public Iterable<Movie> findAll() {
        return repo.findAll();
    }

    @GetMapping("/top3")
    public Iterable<Movie> findTop3() {
        return repo.findTop3();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findMovieById(@PathVariable int id) {
        Optional<Movie> movie =  repo.findById(id);
        if (movie.isPresent()) {
            return ResponseEntity.ok(movie.get());
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addmovie")
    public void addMovie (@RequestBody Movie movie) {
    
    }
    
    @PutMapping("/{id}")
    public void putMethodName (@PathVariable int id, @RequestBody Movie movie) {
    
    }

    @DeleteMapping("/{id}")
    public void deleteMovie() {

    }
}
