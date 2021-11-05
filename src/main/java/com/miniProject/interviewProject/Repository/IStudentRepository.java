package com.miniProject.interviewProject.Repository;

import com.miniProject.interviewProject.Entities.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long>{

    @Transactional
    Student save(Student student);

    @Transactional
    void deleteByStudentId(int studentId);

    @Transactional
    List<Student> findStudentByIdentityNumber(String idNo);

    @Transactional
    List<Student> findStudentByPhoneNumber(String phoneNo);

    @Transactional
    List<Student> findStudentByName(String name);

    @Transactional
    List<Student> findStudentByTownId(int townId);

    @Transactional
    List<Student> findStudentByCityId(int cityId);

    @Transactional
    Student findStudentByStudentId(int id);

    @Transactional
    List<Student> findAll();

}
