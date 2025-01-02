package com.bookapp2.bookapp.services;

import com.bookapp2.bookapp.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    public Book acceptBookDetails(Book book);

    public List<Book> acceptMultipleBookDetails(List<Book> books);

    public Book getBookDetails(int id);

    public Book updateBookDetails(int id, Book book);

    public boolean deleteBook(int id);

    public List<Book> getAllBooks();

    public Page<Book> getPaginatedBookDetails(Pageable pageRequest);
}
