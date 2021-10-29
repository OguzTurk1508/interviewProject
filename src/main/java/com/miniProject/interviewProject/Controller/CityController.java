package com.miniProject.interviewProject.Controller;

import com.miniProject.interviewProject.Entities.City;
import com.miniProject.interviewProject.Service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/intProject/city")
public class CityController {

    private ICityService cityService;

    @Autowired
    public CityController(ICityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/findAll")
    public List<City> findAll(){
        return cityService.findAll();
    }

    @GetMapping("/findById/{cityId}")
    public City findCityById(@PathVariable int cityId){
        return cityService.findCityByCityId(cityId);
    }

}
