package com.bookUser.bookUser.dao;

import com.bookUser.bookUser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
