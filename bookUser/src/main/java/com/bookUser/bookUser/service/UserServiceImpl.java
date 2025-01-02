package com.bookUser.bookUser.service;

import com.bookUser.bookUser.dao.UserDao;
import com.bookUser.bookUser.dto.UserDTO;
import com.bookUser.bookUser.entity.User;
import org.aspectj.apache.bcel.generic.RET;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO,User.class);
        User savedUser = userDao.save(user);
        return modelMapper.map(savedUser,UserDTO.class);
    }

    @Override
    public UserDTO getUserBasedOnId(int id) {
        User user
                = userDao.findById(id)
                  .orElseThrow(()-> new RuntimeException("User does not exist"));
        return modelMapper.map(user,UserDTO.class);
    }

    @Override
    public UserDTO updateUser(User user,int id) {
        User storeUser = userDao.findById(id)
                .orElseThrow(()-> new RuntimeException("User does not exist"));
       // User user = modelMapper.map(storeUser,User.class);
        storeUser.setUserName(user.getUserName());
    //    storeUser.setDateOfBirth(user.getDateOfBirth());
        storeUser.setFirstName(user.getFirstName());
        storeUser.setPassword(user.getPassword());
        storeUser.setLastName(user.getLastName());
   //   storeUser.setPhoneNumbers(user.getPhoneNumbers());
       User user1= userDao.save(storeUser);
        return modelMapper.map(user1,UserDTO.class);
    }

    @Override
    public void deleteUser(int id) {
        User user = userDao.findById(id)
                .orElseThrow(()-> new RuntimeException("Account does not exist"));
         userDao.deleteById(id);
    }

    @Override
    public List<UserDTO> getAllUsers() {
       List<User> users = userDao.findAll();
        return users.stream().map((user)->modelMapper.map(user,UserDTO.class))
                .collect(Collectors.toList());
    }
}
