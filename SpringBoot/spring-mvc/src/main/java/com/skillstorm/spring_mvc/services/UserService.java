package com.skillstorm.spring_mvc.services;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.spring_mvc.dtos.UserDto;
import com.skillstorm.spring_mvc.mapper.UserMapper;
import com.skillstorm.spring_mvc.models.User;

/*
* where you will do all the business logic for controllers & repositories
*/

@Service  //stereotype annotation for @Component
public class UserService {
    @Autowired
    UserMapper mapper;
 

    public List<User> createUserList() {
        List<User> users =  new LinkedList<>();

        users.add(new User(0, "Bryar", "Frank", "13ryarfrank@gmail.com", "1234"));
        users.add(new User(1, "Caroline", "Ahumada", "cahumada@skillstorm.com", "StrongPassword"));
        users.add(new User(2, "Brandon", "Arms", "barms@gmail.com", "4643894"));
        users.add(new User(3, "Kendall", "Budd", "kbudd@gmail.com", "Something"));
        users.add(new User(4, "Andy", "Zheng", "azheng@gmail.com", "cookies4"));

        return users;
    }

    
    public List<UserDto> findAllUsers() {
        List<User> users = createUserList();
        /*
         *      converting List<User> to Stream<User>
         *          then converting Stream<User> to Stream<UserDto>
         */
        List<UserDto> userDtos = users.stream().map(mapper::toDto).collect(Collectors.toList());
        //List<UserDto> userDtos = users.stream().map(mapper::toDto).toList();

        return userDtos;
    }  
    
    public List<User> findAllUsers2() {

        List<User> users = createUserList();
        return users;
    }

    public List<User> findUsersByFirstName(String name) {
        List<User> users =  createUserList();
        List<User> foundUsers =  new LinkedList<>();

        for (User user : users) {
            if (user.getFirstName() == name) {
                foundUsers.add(user);
            }
        }
        return foundUsers;
    }

    public User findById(long id) {
        
        List<User> users =  createUserList();
        return users.get((int)id);
    }

    public List<User> createUser(User user) {

        List<User> users =  createUserList();
        users.add(user);
        return users;
    }

    public User updateUser(long id, User user) {
        user.setId(id);
        return user;
    }

    public User deleteUser(long id) {
        return new User(id, "Kendall", "Budd", "kbudd@skillstorm.com", "password");
    }



}
