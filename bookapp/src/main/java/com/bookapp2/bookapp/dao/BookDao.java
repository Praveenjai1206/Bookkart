package com.bookapp2.bookapp.dao;

import com.bookapp2.bookapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book,Integer> {
}
