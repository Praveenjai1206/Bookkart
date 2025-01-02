package com.bookapp2.bookapp.dao;

import com.bookapp2.bookapp.entity.BookShop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookShopDao extends JpaRepository<BookShop,Integer> {
}
