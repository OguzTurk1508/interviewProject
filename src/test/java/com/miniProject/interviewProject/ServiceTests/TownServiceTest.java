package com.miniProject.interviewProject.ServiceTests;

import com.miniProject.interviewProject.Entities.Town;
import com.miniProject.interviewProject.Repository.ITownRepository;
import com.miniProject.interviewProject.Service.TownService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TownServiceTest {

    @InjectMocks
    TownService townService;

    @Mock
    ITownRepository townRepository;

    @Test
    public void shouldGetAllTowns(){
        List<Town> townList = new ArrayList<Town>();
        Town townA = new Town(1,1,"Karşıyaka");
        Town townB = new Town(4,2,"Kadıköy");
        Town townC = new Town(6,3,"Çankaya");

        townList.add(townA);
        townList.add(townB);
        townList.add(townC);

        when(townRepository.getAllTowns()).thenReturn(townList);

        List<Town> testList = townService.getAllTowns();
        Assert.assertEquals(3,testList.size());
        Assert.assertEquals("Kadıköy",testList.get(1).getName());
    }

    @Test
    public void shouldGetAllTownNames(){
        List<String> townNamesList = new ArrayList<String >();

        townNamesList.add("Karşıyaka");
        townNamesList.add("Kadıköy");
        townNamesList.add("Çankaya");

        when(townRepository.getAllTownNames()).thenReturn(townNamesList);

        List<String> testList = townService.getAllTownNames();
        Assert.assertEquals(3,testList.size());
        Assert.assertEquals("Karşıyaka",testList.get(0));
    }

    @Test
    public void shouldGetTownById(){
        Town town = new Town(1,1,"Karşıyaka");

        when(townRepository.getTownById(1)).thenReturn(town);

        Town returnedTown = townService.getTownById(1);
        Assert.assertEquals(1,returnedTown.getTownId());
        Assert.assertEquals("Karşıyaka",returnedTown.getName());
    }

}
