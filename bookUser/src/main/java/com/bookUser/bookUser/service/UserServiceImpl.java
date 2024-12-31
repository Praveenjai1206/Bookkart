package com.bookUser.bookUser.service;

import com.bookUser.bookUser.dao.UserDao;
import com.bookUser.bookUser.dto.UserDTO;
import com.bookUser.bookUser.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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

//    @Override
//    public User getUserBasedOnId(int id) {
//        return userDao.findById(id).get();
//    }
//
//    @Override
//    public User updateUser(User user) {
//        User storeUser = getUserBasedOnId(user.getUserId());
//        storeUser.setUserName(user.getUserName());
//        storeUser.setDateOfBirth(user.getDateOfBirth());
//        storeUser.setFirstName(user.getFirstName());
//        storeUser.setPassword(user.getPassword());
//        storeUser.setLastName(user.getLastName());
//        storeUser.setPhoneNumbers(user.getPhoneNumbers());
//        return userDao.save(storeUser);
//    }
//
//    @Override
//    public User deleteUser(User user) {
//        userDao.delete(user);
//       return null;
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        return userDao.findAll();
//    }
}
