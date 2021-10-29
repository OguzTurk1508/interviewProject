package com.miniProject.interviewProject.ServiceTests;

import com.miniProject.interviewProject.Entities.City;
import com.miniProject.interviewProject.Repository.ICityRepository;
import com.miniProject.interviewProject.Service.CityService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CityServiceTest {

    @InjectMocks
    CityService cityService;

    @Mock
    ICityRepository cityRepository;

    @DisplayName("Find All Cities")
    @Test
    public void findAllCitiesTest(){
        List<City> cityList = new ArrayList<City>();
        City cityA = new City(1,"İzmir");
        City cityB = new City(2,"İstanbul");
        City cityC = new City(3,"Ankara");

        cityList.add(cityA);
        cityList.add(cityB);
        cityList.add(cityC);

        when(cityRepository.findAll()).thenReturn(cityList);

        List<City> responseList = cityService.findAll();
        assertEquals(3,responseList.size());
        assertEquals(1,responseList.get(0).getCityId());
    }

    @DisplayName("Find City By CityId")
    @Test
    public void findCityByCityId(){
        City city = new City(1,"İzmir");

        when(cityRepository.findCityByCityId(1)).thenReturn(city);

        City returnedCity = cityService.findCityByCityId(1);
        assertEquals(1,returnedCity.getCityId());
        assertEquals("İzmir",returnedCity.getName());
    }

}