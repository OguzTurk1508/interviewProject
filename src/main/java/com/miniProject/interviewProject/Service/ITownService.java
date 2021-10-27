package com.miniProject.interviewProject.Service;

import com.miniProject.interviewProject.Entities.Town;

import java.util.List;

public interface ITownService {

    List<Town> getAllTowns();
    List<String> getAllTownNames();
    Town getTownById(int townId);
}
