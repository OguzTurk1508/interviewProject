package com.miniProject.interviewProject.Service;

import com.miniProject.interviewProject.Repository.ITownRepository;
import com.miniProject.interviewProject.Entities.Town;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TownService implements ITownService {

    private ITownRepository townRepository;

    @Autowired
    public TownService(ITownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    @Transactional
    public List<Town> getAllTowns() {
        return townRepository.getAllTowns();
    }

    @Override
    @Transactional
    public List<String> getAllTownNames() {
        return townRepository.getAllTownNames();
    }

    @Override
    public Town getTownById(int townId) {
        return townRepository.getTownById(townId);
    }
}
