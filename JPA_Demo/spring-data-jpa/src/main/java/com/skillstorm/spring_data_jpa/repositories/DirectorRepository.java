package com.skillstorm.spring_data_jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.spring_data_jpa.models.Director;

public interface DirectorRepository extends JpaRepository<Director, Integer> {
    
}
