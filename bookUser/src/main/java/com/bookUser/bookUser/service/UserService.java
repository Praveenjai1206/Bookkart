package com.bookUser.bookUser.service;

import com.bookUser.bookUser.dto.UserDTO;
import com.bookUser.bookUser.entity.User;

import java.util.List;

public interface UserService {

    public UserDTO createUser(UserDTO user);

//    public UserDTO getUserBasedOnId(int id);
//
//    public  UserDTO updateUser(UserDTO user);
//
//    public  UserDTO deleteUser(UserDTO user);
//    public List<UserDTO> getAllUsers();
}
