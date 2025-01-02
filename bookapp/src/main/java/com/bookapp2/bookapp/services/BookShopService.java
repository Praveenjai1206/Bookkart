package com.bookapp2.bookapp.services;

import com.bookapp2.bookapp.entity.BookShop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookShopService {

    public BookShop acceptBookShopDetails(BookShop bookShop);

    public BookShop getBookShopDetails(int id);

    public BookShop updateBookShopDetails(int id, BookShop bookShop);

    public List<BookShop> getAllBookShops();

    public boolean deleteBookShop(int id);

   // public Page<BookShop> getPaginatedBookDetails(Pageable pageRequest);

}
