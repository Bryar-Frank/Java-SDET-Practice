package com.skillstorm.spring_data_jpa.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.spring_data_jpa.models.Director;
import com.skillstorm.spring_data_jpa.repositories.DirectorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/directors")
public class DirectorController {

    private DirectorRepository repo;

    public DirectorController(DirectorRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public Iterable<Director> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Director getMethodName(@PathVariable int id) {
        return repo.findById(id).get();
    }
    
}

