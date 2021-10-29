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
    public List<Town> findAll() {
        return townRepository.findAll();
    }

    @Override
    @Transactional
    public Town findTownByTownId(int townId) {
        return townRepository.findTownByTownId(townId);
    }
}
