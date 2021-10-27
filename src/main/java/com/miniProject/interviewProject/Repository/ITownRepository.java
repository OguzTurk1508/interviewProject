package com.miniProject.interviewProject.Repository;

import com.miniProject.interviewProject.Entities.Town;

import java.util.List;

public interface ITownRepository {

    List<Town> getAllTowns();
    List<String> getAllTownNames();
    Town getTownById(int townId);
}
