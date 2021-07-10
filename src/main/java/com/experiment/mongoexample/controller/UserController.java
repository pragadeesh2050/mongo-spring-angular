package com.experiment.mongoexample.controller;


import com.experiment.mongoexample.mapper.UserMapper;
import com.experiment.mongoexample.model.User;
import com.experiment.mongoexample.repository.UserRepository;
import com.experiment.mongoexample.exception.UserExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {


    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserController() {

    }

    @Autowired
    public UserController(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<List<User>> GetAllUsers() {
        return new ResponseEntity<List<User>>(this.userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> GetUser(@PathVariable("id") String userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new UserExceptionHandler("User Not Found with " + userId));
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity CreateUser(@RequestBody() User user) {
        System.out.println(user);
        this.userRepository.save(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity UpdateUser(@PathVariable("id") String userId, @RequestBody User userDto) {
        User updateUser = this.userRepository.findById(userId).orElseThrow(() -> new UserExceptionHandler("User Not Found with " + userId));
        updateUser = this.userMapper.MapDtoToUser(userDto, updateUser);
        this.userRepository.save(updateUser);
        return new ResponseEntity<String>("User updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteUser(@PathVariable("id") String userId){
        User deleteUser = this.userRepository.findById(userId).orElseThrow(() -> new UserExceptionHandler("User Not Found with " + userId));
        this.userRepository.delete(deleteUser);
        return new ResponseEntity<String>("User deleted Successfully", HttpStatus.GONE);
    }
}
