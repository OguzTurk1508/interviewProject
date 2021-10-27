package com.miniProject.interviewProject.Controller;

import com.miniProject.interviewProject.Entities.City;
import com.miniProject.interviewProject.Service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/intProject/city")
public class CityController {

    private ICityService cityService;

    @Autowired
    public CityController(ICityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/getAll")
    public List<City> getAllCities(){
        return cityService.getAllCities();
    }

    @GetMapping("/getAllNames")
    public List<String> getAllCityNames(){
        return cityService.getAllCityNames();
    }

    @GetMapping("/getById/{cityId}")
    public City getCityById(@PathVariable int cityId){
        return cityService.getCityById(cityId);
    }

}
