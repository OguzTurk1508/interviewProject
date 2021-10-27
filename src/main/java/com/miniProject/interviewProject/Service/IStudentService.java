package com.miniProject.interviewProject.Service;

import com.miniProject.interviewProject.Entities.Student;

import java.util.List;

public interface IStudentService {

    Student addStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudent(int studentId);
    List<Student> getAllStudents();
    Student getStudentById(int studentId);
}
