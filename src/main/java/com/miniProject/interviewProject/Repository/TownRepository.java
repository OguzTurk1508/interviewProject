package com.miniProject.interviewProject.Repository;

import com.miniProject.interviewProject.Entities.Town;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TownRepository implements ITownRepository {

    @Autowired
    public TownRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Town> getAllTowns() {
        Session session = entityManager.unwrap(Session.class);
        List<Town> townList = session.createQuery("FROM Town",Town.class).getResultList();
        return townList;
    }

    @Override
    @Transactional
    public List<String> getAllTownNames() {
        Session session = entityManager.unwrap(Session.class);
        List<String> townNamesList = session.createQuery("SELECT Town.name FROM Town",String.class).getResultList();
        return townNamesList;
    }

    @Override
    public Town getTownById(int townId) {
        Session session = entityManager.unwrap(Session.class);
        Town town = session.get(Town.class,townId);
        return town;
    }
}
