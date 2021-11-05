package com.miniProject.interviewProject.Service;

import com.miniProject.interviewProject.Entities.Student;

import java.util.List;

public interface IStudentService {

    Student save(Student student);
    void deleteByStudentId(int studentId);
    List<Student> findStudentByIdentityNumber(String idNo);
    List<Student> findStudentByPhoneNumber(String phoneNo);
    List<Student> findStudentByName(String name);
    List<Student> findStudentByTownId(int townId);
    List<Student> findStudentByCityId(int cityId);
    Student findStudentByStudentId(int id);
    List<Student> findAll();
}
