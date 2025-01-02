package com.bookapp2.bookapp.dao;

import com.bookapp2.bookapp.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City,Integer> {
}
