package com.miniProject.interviewProject.Service;

import com.miniProject.interviewProject.Entities.City;

import java.util.List;

public interface ICityService {

    List<City> getAllCities();
    List<String> getAllCityNames();
    City getCityById(int cityId);
}
