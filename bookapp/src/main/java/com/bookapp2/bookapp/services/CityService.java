package com.bookapp2.bookapp.services;

import com.bookapp2.bookapp.entity.Book;
import com.bookapp2.bookapp.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CityService {

    public City acceptCityDetails(City city);

    public City getCityDetails(int id);

    public City updateCityDetails(int id, City city);

   public City getCityDetailsByCityName(String cityName) ;
    public boolean deleteCity(int id);

    public List<City> getAllCityDetails();



}
