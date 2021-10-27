package com.miniProject.interviewProject.Repository;

import com.miniProject.interviewProject.Entities.City;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICityRepository {


    @Transactional
    List<City> getAllCities();

    @Transactional
    List<String> getAllCityNames();

    City getCityById(int cityId);
}
