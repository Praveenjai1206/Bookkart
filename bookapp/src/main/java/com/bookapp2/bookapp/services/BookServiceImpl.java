package com.bookapp2.bookapp.services;

import com.bookapp2.bookapp.dao.BookDao;
import com.bookapp2.bookapp.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookServiceImpl implements BookService{

    public BookDao bookDao;

    @Override
    public Book acceptBookDetails(Book book) {
        return bookDao.save(book);
    }

    @Override
    public List<Book> acceptMultipleBookDetails(List<Book> books) {
        List<Book> savedBooks = new ArrayList<>();
        for (Book book: books) {
            savedBooks.add(acceptBookDetails(book));
        }
        return savedBooks;
    }

    @Override
    public Book getBookDetails(int id) {

        return bookDao.findById(id).get();
    }

    @Override
    public Book updateBookDetails(int id, Book book) {
        Book savedBook = getBookDetails(id);
        savedBook.setBookName(book.getBookName());
        savedBook.setBookDescription(book.getBookDescription());
        savedBook.setBookshops(book.getBookshops());
        savedBook.setNoOfPages(book.getNoOfPages());
        savedBook.setCoverPhotoUrl(book.getCoverPhotoUrl());
        savedBook.setReleaseDate(book.getReleaseDate());
        savedBook.setTrailerUrl(book.getTrailerUrl());
        return bookDao.save(savedBook);
    }

    @Override
    public boolean deleteBook(int id) {

        Book savedBook = getBookDetails(id);
        if (savedBook==null){
            return false;
        }
        bookDao.delete(savedBook);
        return true;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public Page<Book> getPaginatedBookDetails(Pageable pageRequest) {
        return bookDao.findAll(pageRequest);
    }
}
