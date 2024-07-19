package com.skillstorm.spring_data_jpa.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skillstorm.spring_data_jpa.models.Movie;
import com.skillstorm.spring_data_jpa.repositories.MovieRepository;

@Service
public class MovieService {

    private MovieRepository repo;

    // use dependency injection to get an instance of the MovieRepository
    public MovieService(MovieRepository repo) {
        this.repo = repo;
    }

    public Iterable<Movie> findAll() {
        return repo.findAll();
    }

    public List<Movie> findTop3() {
        return repo.findTop3();
    }

    public Optional<Movie> findById(int id) {
        return repo.findById(id);
    }

    public Movie save(Movie movie) {
        return repo.save(movie);
    }

    public void update(int id, Movie movie) {
        /*
         * create a new record in the db if attempt to update etity that doesn't exist?
         *      YES! because creating records change the database if multiple requests happen
         */
        if (!repo.existsById(id)) {
            throw new NoSuchElementException("Movie with id " + id + "does not exist");
        }
        movie.setId(id);
        repo.save(movie);
    }

    public void deleteById(int id) {
        /*
         * warn them if they are attempting to delete movie that doesn't exist?
         *      NO! because HTTP DELETE requests should be idempotent
         */
        repo.deleteById(id);
    }


}
