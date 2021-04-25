package com.decipherzone.notificationstorage.controller;

import com.decipherzone.notificationstorage.dto.NotificationRequest;
import com.decipherzone.notificationstorage.dto.NotificationResponse;
import com.decipherzone.notificationstorage.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Notification")
public class NotificationController {

@Autowired
NotificationService notificationService;
    //Show all data
    @GetMapping("/")
    public List<NotificationResponse> response()
    {
        return notificationService.showData();
    }



    //show by id
    @GetMapping("/{id}")
    public ResponseEntity<Object> get(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(notificationService.showById(id));
    }



    //save data
    @PostMapping("/")
    public ResponseEntity<String> addUser(@Valid @RequestBody NotificationRequest request)
    {
        return notificationService.addUser(request);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@Valid @RequestBody NotificationRequest request, @PathVariable Integer id) {
        return notificationService.updateUser(request, id);
    }


    //delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") Integer id) {

        return notificationService.deleteUser(id);
    }


}