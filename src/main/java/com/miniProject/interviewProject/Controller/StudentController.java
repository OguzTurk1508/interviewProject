package com.miniProject.interviewProject.Controller;

import com.miniProject.interviewProject.Entities.Student;
import com.miniProject.interviewProject.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/intProject/student")
public class StudentController {

    private IStudentService studentService;

    @Autowired
    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @PostMapping("/update")
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @PostMapping("/delete/{studentId}")
    public void addStudent(@PathVariable int studentId){
        studentService.deleteStudent(studentId);
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/getById/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        return studentService.getStudentById(studentId);
    }
}
