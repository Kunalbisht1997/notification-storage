package com.decipherzone.notificationstorage.service;

import com.decipherzone.notificationstorage.dto.NotificationRequest;
import com.decipherzone.notificationstorage.dto.NotificationResponse;
import com.decipherzone.notificationstorage.exception.ResourceNotFoundException;
import com.decipherzone.notificationstorage.model.Notification;
import com.decipherzone.notificationstorage.repository.NotificationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificationService {
    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    ModelMapper modelMapper;

    //show all user
    public List<NotificationResponse> showData() {

        List<Notification> users = notificationRepository.findAll();
        List<NotificationResponse> response = users.stream()
                .map(user -> modelMapper.map(user, NotificationResponse.class)).collect(Collectors.toList());
        return response;
    }

    // to show user by id
    public NotificationResponse showById(Integer id) {
        Optional<Notification> user=notificationRepository.findById(id);
        if (user.isPresent()) {
            NotificationResponse response=modelMapper.map(user.get(),NotificationResponse.class);
            return response;
        } else {
            throw new ResourceNotFoundException(String.format("User not found with id ", id));
        }

    }

    //to add a user
    public ResponseEntity<String> addUser(NotificationRequest request) {
        Notification user=modelMapper.map(request, Notification.class);
        notificationRepository.save(user);
        return new ResponseEntity<>("User created with id "+ user.getId(),HttpStatus.CREATED);
    }



    // to update a user
    public ResponseEntity<String> updateUser(NotificationRequest request, Integer id) {

        Optional<Notification> notification = notificationRepository.findById(id);

        if(!notification.isPresent())
            throw new ResourceNotFoundException(String.format("User not found with id %d", id));

        if (request.getName()!=null)
            notification.get().setName(request.getName());

        if (request.getLastUpdated()!=null)
            notification.get().setLastUpdated(new Date());
        notificationRepository.save(notification.get());
        return ResponseEntity.ok("User updated");
    }



   public ResponseEntity<String> deleteUser(Integer id)
   {
       notificationRepository.deleteById(id);
       return ResponseEntity.ok("User Deleted");
   }

}
