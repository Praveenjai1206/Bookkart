package com.bookapp2.bookapp.services;

import com.bookapp2.bookapp.dao.CityDao;
import com.bookapp2.bookapp.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityServiceImpl implements CityService{

    public CityDao cityDao;

    @Override
    public City acceptCityDetails(City city) {
        return cityDao.save(city);
    }

    @Override
    public City getCityDetails(int id) {
        return cityDao.findById(id).get();
    }

    @Override
    public City updateCityDetails(int id, City city) {
        City savedCity = getCityDetails(id);
        savedCity.setCityName(city.getCityName());

        return cityDao.save(savedCity);
    }

    @Override
    public City getCityDetailsByCityName(String cityName) {

        return null;
    }

    @Override
    public boolean deleteCity(int id) {
        return false;
    }

    @Override
    public List<City> getAllCityDetails() {
        return null;
    }
}
