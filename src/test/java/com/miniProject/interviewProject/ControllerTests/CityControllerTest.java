package com.miniProject.interviewProject.ControllerTests;

import com.miniProject.interviewProject.Controller.CityController;
import com.miniProject.interviewProject.Entities.City;
import com.miniProject.interviewProject.Service.CityService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(CityController.class)
class CityControllerTest {

    private static String CITY_URL = "/intProject/city";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CityService cityService;

    @Test
    public void itShouldGetAllCities() throws Exception{
        List<City> cityList = new ArrayList<City>();
        City cityA = new City(1,"İzmir");
        City cityB = new City(2,"İstanbul");
        City cityC = new City(3,"Ankara");

        cityList.add(cityA);
        cityList.add(cityB);
        cityList.add(cityC);

        when(cityService.getAllCities()).thenReturn(cityList);

        mockMvc.perform(
                MockMvcRequestBuilders.get(CITY_URL+"/getAll"))
                .andExpect(status().isOk());
    }

    @Test
    public void itShouldGetCityById() throws Exception {

        City cityA = new City(1,"İzmir");

        when(cityService.getCityById(1)).thenReturn(cityA);

        mockMvc.perform(MockMvcRequestBuilders.get(CITY_URL+"/getById/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void itShouldGetAllCityNames() throws Exception{
        List<String> cityNamesList = new ArrayList<String>();

        cityNamesList.add("İzmir");
        cityNamesList.add("İstanbul");
        cityNamesList.add("Ankara");

        when(cityService.getAllCityNames()).thenReturn(cityNamesList);

        mockMvc.perform(
                MockMvcRequestBuilders.get(CITY_URL+"/getAllNames"))
                .andExpect(status().isOk());
    }
}