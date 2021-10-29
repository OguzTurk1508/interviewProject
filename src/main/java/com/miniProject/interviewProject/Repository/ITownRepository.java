package com.miniProject.interviewProject.Repository;

import com.miniProject.interviewProject.Entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITownRepository extends JpaRepository<Town, Long> {

    List<Town> findAll();
    Town findTownByTownId(int townId);
}
