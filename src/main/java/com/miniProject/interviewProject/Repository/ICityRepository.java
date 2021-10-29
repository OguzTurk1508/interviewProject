package com.miniProject.interviewProject.Repository;

import com.miniProject.interviewProject.Entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ICityRepository extends JpaRepository<City, Long> {

    @Transactional
    List<City> findAll();

    @Transactional
    City findCityByCityId(int cityId);

}
