package com.miniProject.interviewProject.Service;

import com.miniProject.interviewProject.Entities.Student;

import java.util.List;

public interface IStudentService {

    Student save(Student student);
    void deleteByStudentId(int studentId);
    Student findStudentByIdentityNumber(String idNo);
    Student findStudentByPhoneNumber(String phoneNo);
    Student findStudentByName(String name);
    Student findStudentByStudentId(int id);
    List<Student> findAll();
}
