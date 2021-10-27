package com.miniProject.interviewProject.Entities;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {

    @Id
    @Column(name = "CITY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cityId;

    @Column(name = "NAME")
    private String name;

    public City(int cityId, String name) {
        this.cityId = cityId;
        this.name = name;
    }

    public City() {

    }


    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
