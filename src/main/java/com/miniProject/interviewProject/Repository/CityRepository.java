package com.miniProject.interviewProject.Repository;

import com.miniProject.interviewProject.Entities.City;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CityRepository implements ICityRepository{

    @Autowired
    public CityRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private EntityManager entityManager;

    @Override
    @Transactional
    public List<City> getAllCities() {
        Session session = entityManager.unwrap(Session.class);
        List<City> cityList = session.createQuery("FROM City",City.class).getResultList();
        return cityList;
    }

    @Override
    @Transactional
    public List<String> getAllCityNames() {
        Session session = entityManager.unwrap(Session.class);
        List<String> cityNamesList = session.createQuery("SELECT City.name FROM City ",String.class)
                .getResultList();
        return cityNamesList;
    }

    @Override
    public City getCityById(int cityId) {
        Session session = entityManager.unwrap(Session.class);
        City city = session.get(City.class,cityId);
        return city;
    }

}
