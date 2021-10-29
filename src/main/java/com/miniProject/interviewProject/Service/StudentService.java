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
    public Student save(Student student){return this.studentDAO.save(student);}

    @Override
    @Transactional
    public Student findStudentByStudentId(int studentId){return this.studentDAO.findStudentByStudentId(studentId);}

    @Override
    @Transactional
    public Student findStudentByName(String studentName){return this.studentDAO.findStudentByName(studentName);}

    @Override
    @Transactional
    public Student findStudentByIdentityNumber(String idNo){return this.studentDAO.findStudentByIdentityNumber(idNo);}

    @Override
    @Transactional
    public Student findStudentByPhoneNumber(String phoneNo){return this.studentDAO.findStudentByPhoneNumber(phoneNo);}

    @Override
    @Transactional
    public List<Student> findAll(){return this.studentDAO.findAll();}

    @Override
    @Transactional
    public void deleteByStudentId(int studentId){this.studentDAO.deleteByStudentId(studentId);}

    }
