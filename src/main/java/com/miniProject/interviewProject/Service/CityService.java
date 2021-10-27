package com.miniProject.interviewProject.Service;

import com.miniProject.interviewProject.Repository.ICityRepository;
import com.miniProject.interviewProject.Entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityService implements ICityService{

    private ICityRepository cityRepository;

    @Autowired
    public CityService(ICityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    @Transactional
    public List<City> getAllCities() {
        return cityRepository.getAllCities();
    }

    @Override
    public List<String> getAllCityNames() {
        return cityRepository.getAllCityNames();
    }

    @Override
    public City getCityById(int cityId) {
        return cityRepository.getCityById(cityId);
    }
}
