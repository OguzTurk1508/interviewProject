package com.miniProject.interviewProject.Controller;

import com.miniProject.interviewProject.Entities.Town;
import com.miniProject.interviewProject.Service.ITownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/intProject/town")
public class TownController {

    private ITownService townService;

    @Autowired
    public TownController(ITownService townService) {
        this.townService = townService;
    }

    @GetMapping("/findAll")
    public List<Town> findAll(){
        return townService.findAll();
    }

    @GetMapping("/findById/{townId}")
    public Town getTownById(@PathVariable int townId){
        return townService.findTownByTownId(townId);
    }
}
