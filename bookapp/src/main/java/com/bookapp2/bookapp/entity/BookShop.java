package com.bookapp2.bookapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "bookshops")
public class BookShop {
    @Id
    @GeneratedValue
    private int bookShopId;

    @Column(length = 50, nullable = false, unique = true)
    private String bookShopName;

    @Column( nullable = false)
    private float bookPrice;


     @ManyToOne
     @JoinColumn(name = "city_id",nullable = false)
     private City city;

      @ManyToMany(mappedBy = "bookshops")
      private Set<Book> books;

    public int getBookShopId() {
        return bookShopId;
    }

    public void setBookShopId(int bookShopId) {
        this.bookShopId = bookShopId;
    }

    public String getBookShopName() {
        return bookShopName;
    }

    public void setBookShopName(String bookShopName) {
        this.bookShopName = bookShopName;
    }

    public float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
