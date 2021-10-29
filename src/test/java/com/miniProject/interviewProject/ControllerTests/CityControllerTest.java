package com.miniProject.interviewProject.ControllerTests;

import com.miniProject.interviewProject.Controller.CityController;
import com.miniProject.interviewProject.Entities.City;
import com.miniProject.interviewProject.Service.CityService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
    public void givenCityId_whenFindCityByCityId_thenFindCityStatusOK() throws Exception {
        City city = new City(1,"İzmir");

        when(cityService.findCityByCityId(1)).thenReturn(city);

        mockMvc.perform(MockMvcRequestBuilders.get(CITY_URL+"/findById/"+city.getCityId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(city.getName())));
    }

    @Test
    public void givenCities_whenFindAll_thenFindAllCitiesStatusOK() throws Exception{
        List<City> cityList = new ArrayList<City>();
        City cityA = new City(1,"İzmir");
        City cityB = new City(2,"İstanbul");
        City cityC = new City(3,"Ankara");
        cityList.add(cityA);
        cityList.add(cityB);
        cityList.add(cityC);

        when(cityService.findAll()).thenReturn(cityList);

        mockMvc.perform(MockMvcRequestBuilders.get(CITY_URL+"/findAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)))
                .andExpect(jsonPath("$[0].name",is(cityA.getName())))
                .andExpect(jsonPath("$[1].name",is(cityB.getName())))
                .andExpect(jsonPath("$[2].name",is(cityC.getName())));


    }

}