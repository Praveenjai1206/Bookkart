package com.bookapp2.bookapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name="city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cityId;

    @Column(length = 50, nullable = false, unique = true)
    private String cityName;

    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    private Set<BookShop> bookShops;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Set<BookShop> getBookShops() {
        return bookShops;
    }

    public void setBookShops(Set<BookShop> bookShops) {
        this.bookShops = bookShops;
    }
}
