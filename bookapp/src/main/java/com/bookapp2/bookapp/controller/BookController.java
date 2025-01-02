package com.bookapp2.bookapp.controller;

import com.bookapp2.bookapp.dto.BookDto;
import com.bookapp2.bookapp.entity.Book;
import com.bookapp2.bookapp.services.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "book_app/v1")
public class BookController {
@Autowired
    public BookService bookService;
@Autowired
public ModelMapper modelMapper;

@PostMapping(value = "/books" , consumes = MediaType.APPLICATION_JSON_VALUE,
produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity createBook(BookDto bookDto) {
       Book newBook = modelMapper.map(bookDto,Book.class);
       Book savedBook = bookService.acceptBookDetails(newBook);
       BookDto savedBookDto = modelMapper.map(savedBook,BookDto.class);
       return new ResponseEntity(savedBookDto, HttpStatus.CREATED);
   }


@GetMapping(value = "/books" , consumes = MediaType.APPLICATION_JSON_VALUE,
produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity getAllBooks(){
    List<Book> bookList = bookService.getAllBooks();
    List<BookDto> bookDtoList = new ArrayList<>();
    for (Book book:bookList) {
        bookDtoList.add(modelMapper.map(book,BookDto.class));
    }
    return new ResponseEntity(bookDtoList,HttpStatus.OK);
}

@GetMapping(value = "/book/{id}")
public ResponseEntity getBookBasedOnId(@PathVariable(name = "id") int id){

    Book responseBook = bookService.getBookDetails(id);
    BookDto responseBookDto = modelMapper.map(responseBook,BookDto.class);
    return new ResponseEntity(responseBookDto,HttpStatus.OK);
}

@PutMapping(value = "/book/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity updateBookDetails(@PathVariable(name = "id") int id,
                                        @RequestBody BookDto bookDto){
    Book newMovie = modelMapper.map(bookDto,Book.class);
    Book updateBook = bookService.updateBookDetails(id,newMovie);
    BookDto updateBookDto = modelMapper.map(updateBook,BookDto.class);
    return new ResponseEntity(updateBookDto,HttpStatus.OK);
}
}