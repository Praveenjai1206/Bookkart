package com.bookUser.bookUser.controller;

import com.bookUser.bookUser.dto.UserDTO;
import com.bookUser.bookUser.entity.User;
import com.bookUser.bookUser.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user_app/v1")
public class UserController {
    @Autowired
   public UserService userService;

    @Autowired
    public ModelMapper modelMapper;

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDto){
        return  new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

//    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity getAllUsers(){
//        List<User> userList = userService.getAllUsers();
//        List<UserDTO> userDTOList = new ArrayList<>();
//        userList.forEach(u -> userDTOList.add(modelMapper.map(u,UserDTO.class)));
//        return new ResponseEntity(userDTOList,HttpStatus.OK);
//    }
//    @GetMapping(value = "/user/{id}")
//    public ResponseEntity getUser(@PathVariable(name = "id") int id){
//        User user = userService.getUserBasedOnId(id);
//        UserDTO userDTO = modelMapper.map(user,UserDTO.class);
//        return new ResponseEntity(userDTO,HttpStatus.OK);
//    }
//    @PutMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE,
//    produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity updateUser(@RequestBody UserDTO userDTO){
//        User userToBeUpdated = modelMapper.map(userDTO,User.class);
//        User savedUser = userService.updateUser(userToBeUpdated);
//        UserDTO userDTO1 = modelMapper.map(savedUser,UserDTO.class);
//        return new ResponseEntity<>(userDTO1,HttpStatus.ACCEPTED);
//    }
//    @DeleteMapping(value = "/users/{id}")
//    public ResponseEntity deleteUser(@PathVariable(name = "id") int id){
//        User user = userService.getUserBasedOnId(id);
//        userService.deleteUser(user);
//        return new ResponseEntity<>(null,HttpStatus.OK);
//    }
}
