package com.skillstorm.spring_data_jpa.models;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "directors")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    @Column(length=50)
    private String firstName;
 
    @Column(length=50)
    private String lastName;


    /*
     * Cirular Reference Solution
     *  1.  @JsonIgnore List<Movie> movies; in Director class
     *        -one side of the relationship so it is not serialized
     * 
     *  2.  @JsonManagedReference <--this one is serialized
     *      @JsonBackReference  <--this one is not serialized
     * 
     *  3.  @JsonIdentityReference(alwaysAsId = true) Director director;            in Movies class
     *      @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") class Director { ... }
     */


    // targetEntity is optional because Spring Data implies this from field list type
    @OneToMany(mappedBy = "director", targetEntity = Movie.class) 
    @JsonBackReference
    List<Movie> movies;
 
    public Director(){}
 
    public Director(int id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Director [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", movies=" + movies
                + "]";
    }

    
}
