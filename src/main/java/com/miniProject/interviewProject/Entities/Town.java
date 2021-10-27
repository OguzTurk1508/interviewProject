package com.miniProject.interviewProject.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "town")
public class Town {

    @Id
    @Column(name = "TOWN_ID")
    private int townId;

    @Column(name = "CITY_ID")
    private int cityId;

    @Column(name = "NAME")
    private String name;

    public Town(int townId, int cityId, String name) {
        this.townId = townId;
        this.cityId = cityId;
        this.name = name;
    }

    public Town() {

    }

    public int getTownId() {
        return townId;
    }

    public void setTownId(int townId) {
        this.townId = townId;
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
