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

      @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
      public ResponseEntity<List<UserDTO>> getAllUsers(){
          List<UserDTO> userDTOList = userService.getAllUsers();
          return new ResponseEntity<>(userDTOList,HttpStatus.OK);
      }
    @GetMapping(value = "/user/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable(name = "id") int id){
        UserDTO user = userService.getUserBasedOnId(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @PutMapping(value = "/updateuser/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO
            ,@PathVariable int id){
        User user = modelMapper.map(userDTO,User.class);
        return new ResponseEntity<>(userService.updateUser(user,id),HttpStatus.ACCEPTED);
    }
    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") int id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User is deleted successfully");
    }
}
