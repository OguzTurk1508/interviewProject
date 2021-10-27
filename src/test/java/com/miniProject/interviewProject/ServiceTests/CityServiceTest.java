package com.miniProject.interviewProject.ServiceTests;

import com.miniProject.interviewProject.Entities.City;
import com.miniProject.interviewProject.Repository.ICityRepository;
import com.miniProject.interviewProject.Service.CityService;
import org.junit.Test;
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

    @Test
    public void shouldGetAllCities(){
        List<City> cityList = new ArrayList<City>();
        City cityA = new City(1,"İzmir");
        City cityB = new City(2,"İstanbul");
        City cityC = new City(3,"Ankara");

        cityList.add(cityA);
        cityList.add(cityB);
        cityList.add(cityC);

        when(cityRepository.getAllCities()).thenReturn(cityList);

        List<City> testList = cityService.getAllCities();
        assertEquals(3,testList.size());
        assertEquals(1, testList.get(0).getCityId());
    }

    @Test
    public void shouldGetAllCityNames(){
        List<String> cityNamesList = new ArrayList<String>();

        cityNamesList.add("İstanbul");
        cityNamesList.add("İzmir");
        cityNamesList.add("Ankara");

        when(cityRepository.getAllCityNames()).thenReturn(cityNamesList);

        List<String> testList = cityService.getAllCityNames();
        assertEquals(3,testList.size());
        assertEquals("İstanbul",testList.get(0));
    }

    @Test
    public void shouldGetCityById(){
        City city = new City(1,"İzmir");

        when(cityRepository.getCityById(1)).thenReturn(city);

        City returnedCity = cityService.getCityById(1);
        assertEquals(1,returnedCity.getCityId());
        assertEquals("İzmir",returnedCity.getName());
    }

}