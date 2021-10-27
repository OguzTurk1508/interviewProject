package com.miniProject.interviewProject.Repository;

import com.miniProject.interviewProject.Entities.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IStudentRepository {

    @Transactional
    Student addStudent(Student student);

    @Transactional
    Student updateStudent(Student student);

    @Transactional
    void deleteStudent(int studentId);

    @Transactional
    List<Student> getAllStudents();

    @Transactional
    Student getStudentById(int studentId);
}
