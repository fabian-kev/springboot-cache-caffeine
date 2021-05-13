package com.fabiankevin.springbootcache.controller;

import com.fabiankevin.springbootcache.model.User;
import com.fabiankevin.springbootcache.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("users")
@RestController
public class UserController {


    private final UserService userService;



    @GetMapping("/{id}")
    User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PostMapping
    String  getUser(@RequestBody User user){
        userService.create(user);
        return String.format("You've successfully added %s", user.getName());
    }

    @PutMapping
    String update(@RequestBody User user){
        userService.update(user);
        return String.format("You've successfully updated %s", user.getName());
    }

    @GetMapping
    List<User> getAll(){
        return userService.findAll();
    }



    @GetMapping("/all")
    List<User> all(){
        return userService.findAll();
    }


}
