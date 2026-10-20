package com.vikram.Team_expence_Manager.Controller;

import com.vikram.Team_expence_Manager.Dto.UserRequest;
import com.vikram.Team_expence_Manager.Entity.User;
import com.vikram.Team_expence_Manager.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class userController {
    @Autowired
    UserService userService;

    @PostMapping("/creatingUser")
    ResponseEntity<User> createUser(@RequestBody @Valid UserRequest user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @GetMapping("/getusers")
    List<User> findUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/userById/{id}")
    User findUser(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @DeleteMapping("/deleteuserByID/{id}")
    void deleteUser(@PathVariable Long id){
         userService.deleteUser(id);
    }
}
