package com.miniProject.interviewProject.ControllerTests;

import com.miniProject.interviewProject.Controller.TownController;
import com.miniProject.interviewProject.Entities.Town;
import com.miniProject.interviewProject.Service.TownService;
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
@WebMvcTest(TownController.class)
class TownControllerTest {

    private static String TOWN_URL = "/intProject/town";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TownService townService;

    @Test
    public void givenTownId_whenFindTownById_thenFindTownStatusOK() throws Exception{
        Town town = new Town(1,1,"Buca");

        when(townService.findTownByTownId(1)).thenReturn(town);

        mockMvc.perform(MockMvcRequestBuilders.get(TOWN_URL+"/findById/"+town.getTownId())
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(town.getName())));
    }

    @Test
    public void givenTowns_whenFindAll_thenFindAllTownsStatusOK() throws Exception{
        Town townA = new Town(1,1,"Buca");
        Town townB = new Town(2,1,"Karşıyaka");
        Town townC = new Town(3,1,"Konak");

        List<Town> townList = new ArrayList<Town>();
        townList.add(townA);
        townList.add(townB);
        townList.add(townC);

        when(townService.findAll()).thenReturn(townList);

        mockMvc.perform(MockMvcRequestBuilders.get(TOWN_URL+"/findAll")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)))
                .andExpect(jsonPath("$[0].name",is(townA.getName())))
                .andExpect(jsonPath("$[1].name",is(townB.getName())))
                .andExpect(jsonPath("$[2].name",is(townC.getName())));

    }
}