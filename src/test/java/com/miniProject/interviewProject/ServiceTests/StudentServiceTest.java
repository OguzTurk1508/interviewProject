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
    public void getAllStudentsTest(){
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

        when(studentRepository.getAllStudents()).thenReturn(studentList);

        List<Student> testList = studentService.getAllStudents();
        assertEquals(3,testList.size());
        Assert.assertEquals(1, testList.get(0).getStudentId());
    }

    @Test
    public void getStudentByIdTest(){
        Student student = new Student(1,1,1,
                "12345678901","Oguz Turk","123");

        when(studentRepository.getStudentById(1)).thenReturn(student);

        Student testStudent = studentService.getStudentById(1);
        assertEquals(testStudent.getStudentId(),student.getStudentId());
        assertEquals(testStudent.getName(),student.getName());
    }

    @Test
    public void addStudentTest(){
        Student student = new Student(1,1,1,
                "12345678901","Oguz Turk","123");

        studentService.addStudent(student);

        verify(studentRepository,times(1)).addStudent(student);
    }

    @Test
    public void updateStudentTest(){
        Student student = new Student(1,1,1,
                "12345678901","Oguz Turk","123");

        studentService.updateStudent(student);

        verify(studentRepository,times(1)).updateStudent(student);
    }

    @Test
    public void deleteStudentTest(){
        studentService.deleteStudent(1);

        verify(studentRepository,times(1)).deleteStudent(1);
    }

}
