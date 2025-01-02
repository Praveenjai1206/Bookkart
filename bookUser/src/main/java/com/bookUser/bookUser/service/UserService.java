package com.bookUser.bookUser.service;

import com.bookUser.bookUser.dto.UserDTO;
import com.bookUser.bookUser.entity.User;

import java.util.List;

public interface UserService {

    public UserDTO createUser(UserDTO userDTO);

    public UserDTO getUserBasedOnId(int id);

    public  UserDTO updateUser(User user,int id);

    public  void deleteUser(int id);
    public List<UserDTO> getAllUsers();
}
