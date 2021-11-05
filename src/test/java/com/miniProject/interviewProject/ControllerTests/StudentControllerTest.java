package com.miniProject.interviewProject.ControllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.miniProject.interviewProject.Controller.StudentController;
import com.miniProject.interviewProject.Entities.Student;
import com.miniProject.interviewProject.Service.StudentService;
import org.junit.jupiter.api.DisplayName;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
class StudentControllerTest {

    private static String STUDENT_URL = "/intProject/student";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    StudentService studentService;

    @DisplayName("Find All Students")
    @Test
    public void givenStudents_whenFindAllStudents_thenFindAllStudentsStatusOK() throws Exception{
        Student studentA = new Student(1,1,1,"testIdentityNumberA","testNameA","testPhoneNumberA");
        Student studentB = new Student(2,1,1,"testIdentityNumberB","testNameB","testPhoneNumberB");
        Student studentC = new Student(3,1,1,"testIdentityNumberC","testNameC","testPhoneNumberC");

        List<Student> studentList = new ArrayList<Student>();
        studentList.add(studentA);
        studentList.add(studentB);
        studentList.add(studentC);

        when(studentService.findAll()).thenReturn(studentList);

        mockMvc.perform(MockMvcRequestBuilders.get(STUDENT_URL+"/findAll")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)))
                .andExpect(jsonPath("$[0].studentId",is(1)))
                .andExpect(jsonPath("$[1].studentId",is(2)))
                .andExpect(jsonPath("$[2].studentId",is(3)));
    }

    @DisplayName("Find Student By ID")
    @Test
    public void givenStudentId_whenFindStudentById_thenFindStudentStatusOK() throws Exception{
        Student student = new Student(1,1,1,"testIdentityNumber",
                "testName","testPhoneNumber");

        when(studentService.findStudentByStudentId(1)).thenReturn(student);

        mockMvc.perform(MockMvcRequestBuilders.get(STUDENT_URL+"/findById/"+student
                .getStudentId())
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(student.getName())))
                .andExpect(jsonPath("$.phoneNumber",is(student.getPhoneNumber())))
                .andExpect(jsonPath("$.identityNumber",is(student.getIdentityNumber())))
                .andExpect(jsonPath("$.studentId",is(student.getStudentId())))
                .andExpect(jsonPath("$.townId",is(student.getTownId())))
                .andExpect(jsonPath("$.cityId",is(student.getCityId())));
    }

    @DisplayName("Find Student By IdentityNumber")
    @Test
    public void givenStudentIdentityNo_whenFindStudentByIdentityNo_thenFindStudentStatusOK() throws Exception{
        Student student = new Student(1,1,1,"testIdentityNumber",
                "testName","testPhoneNumber");

        List<Student> studentList = new ArrayList<Student>();
        studentList.add(student);

        when(studentService.findStudentByIdentityNumber("testIdentityNumber"))
                .thenReturn(studentList);

        mockMvc.perform(MockMvcRequestBuilders.get(STUDENT_URL+"/findByIdentityNo/"+studentList
                .get(0).getIdentityNumber())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name",is(student.getName())))
                .andExpect(jsonPath("$[0].phoneNumber",is(student.getPhoneNumber())))
                .andExpect(jsonPath("$[0].identityNumber",is(student.getIdentityNumber())))
                .andExpect(jsonPath("$[0].studentId",is(student.getStudentId())))
                .andExpect(jsonPath("$[0].townId",is(student.getTownId())))
                .andExpect(jsonPath("$[0].cityId",is(student.getCityId())));
    }

    @DisplayName("Find Student By Name")
    @Test
    public void givenStudentName_whenFindStudentByName_thenFindStudentStatusOK() throws Exception{
        Student student = new Student(1,1,1,"testIdentityNumber",
                "testName","testPhoneNumber");

        List<Student> studentList = new ArrayList<Student>();
        studentList.add(student);

        when(studentService.findStudentByName("testName")).thenReturn(studentList);

        mockMvc.perform(MockMvcRequestBuilders.get(STUDENT_URL+"/findByName/"+studentList.get(0)
                .getName())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name",is(student.getName())))
                .andExpect(jsonPath("$[0].phoneNumber",is(student.getPhoneNumber())))
                .andExpect(jsonPath("$[0].identityNumber",is(student.getIdentityNumber())))
                .andExpect(jsonPath("$[0].studentId",is(student.getStudentId())))
                .andExpect(jsonPath("$[0].townId",is(student.getTownId())))
                .andExpect(jsonPath("$[0].cityId",is(student.getCityId())));
    }

    @DisplayName("Find Student By PhoneNumber")
    @Test
    public void givenStudentPhoneNumber_whenFindStudentByPhoneNumber_thenFindStudentStatusOK() throws Exception{
        Student student = new Student(1,1,1,"testIdentityNumber","testName","testPhoneNumber");
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(student);

        when(studentService.findStudentByPhoneNumber("testPhoneNumber")).thenReturn(studentList);

        mockMvc.perform(MockMvcRequestBuilders.get(STUDENT_URL+"/findByPhoneNumber/"+studentList
                .get(0).getPhoneNumber())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name",is(student.getName())))
                .andExpect(jsonPath("$[0].phoneNumber",is(student.getPhoneNumber())))
                .andExpect(jsonPath("$[0].identityNumber",is(student.getIdentityNumber())))
                .andExpect(jsonPath("$[0].studentId",is(student.getStudentId())))
                .andExpect(jsonPath("$[0].townId",is(student.getTownId())))
                .andExpect(jsonPath("$[0].cityId",is(student.getCityId())));
    }

    @DisplayName("Add Student")
    @Test
    public void givenStudent_whenAddStudent_thenAddStudentStatusOK() throws Exception{
        Student student = new Student(1,1,1,"testIdentityNumber","testName","testPhoneNumber");

        when(studentService.save(student)).thenReturn(student);


        mockMvc.perform(MockMvcRequestBuilders.post(STUDENT_URL+"/save")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"studentId\":1,\"cityId\":1,\"townId\":1,\"identityNumber\":\"testIdentityNumber\"," +
                "\"name\":\"testName\",\"phoneNumber\":\"testPhoneNumber\"}")
        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @DisplayName("Delete Student By ID")
    @Test
    public void givenStudentId_whenDeleteStudentById_thenDeleteStudentStatusOK() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post(STUDENT_URL+"/deleteByStudentId/1")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}