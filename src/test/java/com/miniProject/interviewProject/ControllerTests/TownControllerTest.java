package com.miniProject.interviewProject.ControllerTests;

import com.miniProject.interviewProject.Controller.TownController;
import com.miniProject.interviewProject.Entities.Town;
import com.miniProject.interviewProject.Service.TownService;
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
@WebMvcTest(TownController.class)
class TownControllerTest {

    private static String TOWN_URL = "/intProject/town";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TownService townService;

    @Test
    public void itShouldGetAllTowns() throws Exception{
        List<Town> townList = new ArrayList<Town>();
        Town townA = new Town(1,1,"Karşıyaka");
        Town townB = new Town(4,2,"Kadıköy");
        Town townC = new Town(6,3,"Çankaya");

        townList.add(townA);
        townList.add(townB);
        townList.add(townC);

        when(townService.getAllTowns()).thenReturn(townList);

        mockMvc.perform(MockMvcRequestBuilders.get(TOWN_URL+"/getAll"))
                .andExpect(status().isOk());
    }

    @Test
    public void itShouldGetAllTownNames() throws Exception {
        List<String> townNamesList = new ArrayList<String>();
        townNamesList.add("Karşıyaka");
        townNamesList.add("KAdıköy");
        townNamesList.add("Çankaya");

        when(townService.getAllTownNames()).thenReturn(townNamesList);

        mockMvc.perform(MockMvcRequestBuilders.get(TOWN_URL+"/getAllNames"))
                .andExpect(status().isOk());
    }

    @Test
    public void itShouldGetTownById() throws Exception{
        Town townA = new Town(1,1,"Karşıyaka");
        when(townService.getTownById(1)).thenReturn(townA);

        mockMvc.perform(MockMvcRequestBuilders.get(TOWN_URL+"/getById/1"))
                .andExpect(status().isOk());
    }

}