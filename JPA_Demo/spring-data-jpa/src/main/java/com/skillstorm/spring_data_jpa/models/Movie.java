package com.skillstorm.spring_data_jpa.models;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "movies") // optional annotation if name of db table matches class name
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // strategies: IDENTITY or AUTO 
    private int id;

    @Column(length = 50)
    private String movieTitle;

    @Min(value = 0)
    @Max(value = 10)
    private int rating;

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

    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    @NotNull
    @JoinColumn(name = "director_id")
    @JsonManagedReference
    private Director director;

    // do not do 
    // private int directorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie [id=" + id + ", movieTitle=" + movieTitle + ", rating=" + rating + ", director " + 
            (director == null ? null : director.getFirstName()) + " " + 
            (director == null ? null : director.getLastName()) + "]";
    }

    // don't add the foreign id column

    

}
