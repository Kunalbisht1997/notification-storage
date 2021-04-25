package com.decipherzone.notificationstorage.service;

import com.decipherzone.notificationstorage.dto.UserResponse;
import com.decipherzone.notificationstorage.exception.ResourceNotFoundException;
import com.decipherzone.notificationstorage.dto.UserRequest;
import com.decipherzone.notificationstorage.model.User;
import com.decipherzone.notificationstorage.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    //show all user
    public List<UserResponse> showData() {

        List<User> users = userRepository.findAll();
        List<UserResponse> response = users.stream()
                .map(user -> modelMapper.map(user, UserResponse.class)).collect(Collectors.toList());
        return response;
    }

    // to show user by id
    public UserResponse showById(Integer id) {
        Optional<User> user=userRepository.findById(id);
        if (user.isPresent()) {
            UserResponse response=modelMapper.map(user.get(),UserResponse.class);
            return response;
        } else {
            throw new ResourceNotFoundException(String.format("User not found with id", id));
        }

    }

    //to add a user
    public ResponseEntity<String> addUser(UserRequest userRequest) {
        User user=modelMapper.map(userRequest,User.class);
        userRepository.save(user);
        return new ResponseEntity<>("User created with id "+ user.getId(),HttpStatus.CREATED);
    }



    // to update a user
    public ResponseEntity<String> updateUser(UserRequest userRequest, Integer id) {

        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent())
            throw new ResourceNotFoundException(String.format("User not found with id %d", id));

        if (userRequest.getName()!=null)
            user.get().setName(userRequest.getName());

        if (userRequest.getPhone()!=null)
            user.get().setPhone(userRequest.getPhone());

        if (userRequest.getEmail()!=null)
            user.get().setEmail(userRequest.getEmail());

        userRepository.save(user.get());
        return ResponseEntity.ok("User updated");
    }



   public ResponseEntity<String> deleteUser(Integer id)
   {
       userRepository.deleteById(id);
       return ResponseEntity.ok("User Deleted");
   }

}
