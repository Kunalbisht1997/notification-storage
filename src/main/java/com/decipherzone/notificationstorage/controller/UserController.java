package com.decipherzone.notificationstorage.controller;

import com.decipherzone.notificationstorage.dto.UserRequest;
import com.decipherzone.notificationstorage.dto.UserResponse;
import com.decipherzone.notificationstorage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

@Autowired
UserService userService;
    //Show all data
    @GetMapping("/")
    public List<UserResponse> response()
    {
        return userService.showData();
    }



    //show by id
    @GetMapping("/{id}")
    public ResponseEntity<Object> get(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(userService.showById(id));
    }



    //save data
    @PostMapping("/")
    public ResponseEntity<String> addUser(@Valid @RequestBody UserRequest userRequest)
    {
        return userService.addUser(userRequest);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@Valid @RequestBody UserRequest userRequest, @PathVariable Integer id) {
        return userService.updateUser(userRequest, id);
    }


    //delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") Integer id) {

        return userService.deleteUser(id);
    }


}