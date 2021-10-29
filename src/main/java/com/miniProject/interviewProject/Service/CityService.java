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
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findCityByCityId(int cityId) {
        return cityRepository.findCityByCityId(cityId);
    }
}
