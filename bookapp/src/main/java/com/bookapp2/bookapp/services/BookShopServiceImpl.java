package com.bookapp2.bookapp.services;

import com.bookapp2.bookapp.dao.BookShopDao;
import com.bookapp2.bookapp.entity.BookShop;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookShopServiceImpl implements BookShopService{

    public BookShopDao bookShopDao;

    @Override
    public BookShop acceptBookShopDetails(BookShop bookShop) {
        return bookShopDao.save(bookShop);
    }

    @Override
    public BookShop getBookShopDetails(int id) {
        return bookShopDao.findById(id).get();
    }

    @Override
    public BookShop updateBookShopDetails(int id, BookShop bookShop) {

        BookShop savedBookShop = getBookShopDetails(id);
        savedBookShop.setBookShopName(bookShop.getBookShopName());
        savedBookShop.setBookPrice(bookShop.getBookPrice());
        return bookShopDao.save(savedBookShop);
    }

    @Override
    public List<BookShop> getAllBookShops() {
        return bookShopDao.findAll();
    }

    @Override
    public boolean deleteBookShop(int id) {
        BookShop savedBookShop = getBookShopDetails(id);
        if (savedBookShop == null){
            return false;
        }
        bookShopDao.delete(savedBookShop);
        return true;
    }
}
