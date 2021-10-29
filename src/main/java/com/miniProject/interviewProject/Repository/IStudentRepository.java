package com.miniProject.interviewProject.Repository;

import com.miniProject.interviewProject.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

    @Transactional
    Student save(Student student);

    @Transactional
    void deleteByStudentId(int studentId);

    @Transactional
    List<Student> findAll();

    @Transactional
    Student findStudentByIdentityNumber(String idNo);

    @Transactional
    Student findStudentByPhoneNumber(String phoneNo);

    @Transactional
    Student findStudentByName(String name);

    @Transactional
    Student findStudentByStudentId(int id);
}
