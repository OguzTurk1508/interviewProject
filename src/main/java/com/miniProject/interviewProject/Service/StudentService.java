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
    public List<Student> findStudentByName(String studentName){return this.studentDAO.findStudentByName(studentName);}

    @Override
    @Transactional
    public List<Student> findStudentByTownId(int townId) {
        return this.studentDAO.findStudentByTownId(townId);
    }

    @Override
    @Transactional
    public List<Student> findStudentByCityId(int cityId) {
        return this.studentDAO.findStudentByCityId(cityId);
    }

    @Override
    @Transactional
    public List<Student> findStudentByIdentityNumber(String idNo){return this.studentDAO.findStudentByIdentityNumber(idNo);}

    @Override
    @Transactional
    public List<Student> findStudentByPhoneNumber(String phoneNo){return this.studentDAO.findStudentByPhoneNumber(phoneNo);}

    @Override
    @Transactional
    public List<Student> findAll(){return studentDAO.findAll();}

    @Override
    @Transactional
    public void deleteByStudentId(int studentId){this.studentDAO.deleteByStudentId(studentId);}

    }
