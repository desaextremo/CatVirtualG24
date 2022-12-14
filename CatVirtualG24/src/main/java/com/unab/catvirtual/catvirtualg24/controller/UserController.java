package com.unab.catvirtual.catvirtualg24.controller;

import com.unab.catvirtual.catvirtualg24.enitity.User;
import com.unab.catvirtual.catvirtualg24.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> listUsers(){
        return userService.listUsers();
    }

    @GetMapping("/{identification}")
    public User queryUser(@PathVariable("identification") String identification){
        return userService.queryUser(identification);
    }

    @PostMapping("/new")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/save")
    public User saveBook(@RequestBody User User){
        return userService.saveUser(User);
    }

    @DeleteMapping("/{identification}")
    public void deleteBook(@PathVariable("identification") String identification){
        userService.deleteUser(identification);
    }
}
