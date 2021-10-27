package com.miniProject.interviewProject.Controller;

import com.miniProject.interviewProject.Entities.Town;
import com.miniProject.interviewProject.Service.ITownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/intProject/town")
public class TownController {

    private ITownService townService;

    @Autowired
    public TownController(ITownService townService) {
        this.townService = townService;
    }

    @GetMapping("/getAll")
    public List<Town> getAllTowns(){
        return townService.getAllTowns();
    }

    @GetMapping("/getAllNames")
    public List<String> getAllTownNames(){
        return townService.getAllTownNames();
    }

    @GetMapping("/getById/{townId}")
    public Town getTownById(@PathVariable int townId){
        return townService.getTownById(townId);
    }
}
