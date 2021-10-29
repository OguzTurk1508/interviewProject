package com.miniProject.interviewProject.Service;

import com.miniProject.interviewProject.Entities.City;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICityService {

    List<City> findAll();
    City findCityByCityId(int cityId);
}
