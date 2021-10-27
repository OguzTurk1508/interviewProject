
package com.miniProject.interviewProject.Repository;

import com.miniProject.interviewProject.Entities.Student;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {

    @Autowired
    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private EntityManager entityManager;

    @Override
    @Transactional
    public Student addStudent(Student student) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(student);
        return student;
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(student);
        return student;
    }

    @Override
    @Transactional
    public void deleteStudent(int studentId) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(getStudentById(studentId));
    }

    @Override
    @Transactional
    public List<Student> getAllStudents() {
        Session session = entityManager.unwrap(Session.class);
        List<Student> studentList = session.createQuery("from Student",Student.class).getResultList();
        return studentList;
    }

    @Override
    @Transactional
    public Student getStudentById(int studentId){
        Session session = entityManager.unwrap(Session.class);
        Student student = session.get(Student.class,studentId);
        return student;
    }
}
