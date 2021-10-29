package com.miniProject.interviewProject.ServiceTests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.miniProject.interviewProject.Repository.IStudentRepository;
import com.miniProject.interviewProject.Entities.Student;
import com.miniProject.interviewProject.Service.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {

    @InjectMocks
    StudentService studentService;

    @Mock
    IStudentRepository studentRepository;

    @Test
    public void findAllStudentsTest(){
        List<Student> studentList = new ArrayList<Student>();
        Student studentA = new Student(1,1,1,
                "12345678901","Oguz Turk","123");
        Student studentB = new Student(2,2,1,
                "12345678902","Abdullah Turk","124");
        Student studentC = new Student(3,3,1,
                "12345678903","Omer Turk","125");

        studentList.add(studentA);
        studentList.add(studentB);
        studentList.add(studentC);

        when(studentRepository.findAll()).thenReturn(studentList);

        List<Student> testList = studentService.findAll();
        assertEquals(3,testList.size());
        Assert.assertEquals(1, testList.get(0).getStudentId());
    }

    @Test
    public void findStudentByIdTest(){
        Student student = new Student(1,1,1,
                "12345678901","Oguz Turk","123");

        when(studentRepository.findStudentByStudentId(1)).thenReturn(student);

        Student testStudent = studentService.findStudentByStudentId(1);
        assertEquals(testStudent.getStudentId(),student.getStudentId());
        assertEquals(testStudent.getName(),student.getName());
    }

    @Test
    public void findStudentByName(){
        Student student = new Student(1,1,1,
                "12345678901","Oguz Turk","123");

        when(studentRepository.findStudentByName("Oguz Turk")).thenReturn(student);

        Student testStudent = studentService.findStudentByName("Oguz Turk");
        assertEquals(testStudent.getStudentId(),student.getStudentId());
        assertEquals(testStudent.getName(),student.getName());
    }

    @Test
    public void findStudentByIdentityNumber(){
        Student student = new Student(1,1,1,
                "12345678901","Oguz Turk","123");

        when(studentRepository.findStudentByIdentityNumber("12345678901")).thenReturn(student);

        Student testStudent = studentService.findStudentByIdentityNumber("12345678901");
        assertEquals(testStudent.getStudentId(),student.getStudentId());
        assertEquals(testStudent.getName(),student.getName());
    }

    @Test
    public void findStudentByPhoneNumber(){
        Student student = new Student(1,1,1,
                "12345678901","Oguz Turk","123");

        when(studentRepository.findStudentByPhoneNumber("123")).thenReturn(student);

        Student testStudent = studentService.findStudentByPhoneNumber("123");
        assertEquals(testStudent.getStudentId(),student.getStudentId());
        assertEquals(testStudent.getName(),student.getName());
    }

    @Test
    public void saveStudentTest(){
        Student student = new Student(1,1,1,
                "12345678901","Oguz Turk","123");

        studentService.save(student);

        verify(studentRepository,times(1)).save(student);
    }

    @Test
    public void deleteStudentByStudentIdTest(){
        studentService.deleteByStudentId(1);

        verify(studentRepository,times(1)).deleteByStudentId(1);
    }



}
