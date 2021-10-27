package com.miniProject.interviewProject.ControllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.miniProject.interviewProject.Controller.StudentController;
import com.miniProject.interviewProject.Entities.Student;
import com.miniProject.interviewProject.Service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
class StudentControllerTest {

    private static String STUDENT_URL = "/intProject/student";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    StudentService studentService;

    @Test
    public void itShouldSaveStudentSuccesfully() throws Exception{
        Student student = new Student(1,1,1,
                "12345678901","Oguz Turk","123");

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String studentJson = ow.writeValueAsString(student);

        when(studentService.addStudent(any())).thenReturn(student);

        mockMvc.perform(
                MockMvcRequestBuilders.post(STUDENT_URL+"/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    public void itShouldUpdateStudentSuccesfully() throws Exception{
        Student student = new Student(1,1,1,
                "12345678901","Oguz Turk","123");

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String studentJson = ow.writeValueAsString(student);

        when(studentService.updateStudent(any())).thenReturn(student);

        mockMvc.perform(
                MockMvcRequestBuilders.post(STUDENT_URL+"/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    public void itShouldGetAllStudents() throws Exception{

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

        when(studentService.getAllStudents()).thenReturn(studentList);

        mockMvc.perform(
                MockMvcRequestBuilders.get(STUDENT_URL+"/getAll"))
                .andExpect(status().isOk());
    }

    @Test
    public void itShouldGetStudentById() throws Exception{
        Student studentA = new Student(1,1,1,
                "12345678901","Oguz Turk","123");

        when(studentService.getStudentById(1)).thenReturn(studentA);

        mockMvc.perform(
                MockMvcRequestBuilders.get(STUDENT_URL+"/getById/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void itShouldDeleteStudentById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(STUDENT_URL+"/delete/1")
                            .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}