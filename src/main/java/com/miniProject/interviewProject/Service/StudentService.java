package com.miniProject.interviewProject.Service;

import com.miniProject.interviewProject.Repository.IStudentRepository;
import com.miniProject.interviewProject.Entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService{

    private IStudentRepository studentDAO;

    @Autowired
    public StudentService(IStudentRepository studentRepository) {
        this.studentDAO = studentRepository;
    }

    @Override
    @Transactional
    public Student addStudent(Student student) {
        return this.studentDAO.addStudent(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        return this.studentDAO.updateStudent(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int studentId) {
        this.studentDAO.deleteStudent(studentId);
    }

    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return this.studentDAO.getAllStudents();
    }

    @Override
    @Transactional
    public Student getStudentById(int studentId){
        return this. studentDAO.getStudentById(studentId);
    }
}
