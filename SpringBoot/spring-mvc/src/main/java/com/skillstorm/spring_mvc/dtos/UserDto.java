package com.skillstorm.spring_mvc.dtos;
/* 
 * DATA TRANSFER OBJECT
 *      facilitate the transfer of data for your models
 *      moew specifically, rather than transferring your model, you transfer its dto
 * 
 *      DTO isn't going to have everything that a model would
 *      prevents unneeded information from passing from front end (i.e. passwords)
 * 
 *      in conjuction with your DTO, you will have a mapper
 *              will convert your DTO to your model and vice versa
 * 
 *      You can have multiple DTOs
 *              ie. user creation needs password, but doesn't need id
 */
public class UserDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    
    public UserDto() {
    }
    
    public UserDto(long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

        public long getId() {
        return id;
    }
    public void setId(long id) {
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }
}
