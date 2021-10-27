package com.miniProject.interviewProject.Entities;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    @Column(name = "STUDENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column(name = "CITY_ID")
    private int cityId;

    @Column(name = "TOWN_ID")
    private int townId;

    @Column(name = "IDENTITY_NUMBER")
    private String identityNumber;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    public Student(int studentId, int cityId, int townId, String identityNumber, String name, String phoneNumber) {
        this.studentId = studentId;
        this.cityId = cityId;
        this.townId = townId;
        this.identityNumber = identityNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Student() {

    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getTownId() {
        return townId;
    }

    public void setTownId(int townId) {
        this.townId = townId;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
