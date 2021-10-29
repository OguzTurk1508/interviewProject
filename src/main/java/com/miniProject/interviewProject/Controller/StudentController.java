package com.miniProject.interviewProject.Controller;

import com.miniProject.interviewProject.Entities.Student;
import com.miniProject.interviewProject.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/intProject/student")
public class StudentController {

    private IStudentService studentService;

    @Autowired
    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public Student save(@RequestBody Student student){return studentService.save(student);}

    @GetMapping("/findById/{studentId}")
    public Student findStudentById(@PathVariable int studentId){return studentService.findStudentByStudentId(studentId);}

    @GetMapping("/findByPhoneNumber/{phoneNumber}")
    public Student findStudentByPhoneNumber(@PathVariable String phoneNumber){return studentService.findStudentByPhoneNumber(phoneNumber);}

    @GetMapping("/findByIdentityNo/{identityNumber}")
    public Student findStudentIdentityNumber(@PathVariable String identityNumber){return studentService.findStudentByIdentityNumber(identityNumber);}

    @GetMapping("/findByName/{studentName}")
    public Student findStudentStudentName(@PathVariable String studentName){return studentService.findStudentByName(studentName);}

    @GetMapping("/findAll")
    public List<Student> findAll(){return studentService.findAll();}

    @PostMapping("/deleteByStudentId/{studentId}")
    public void deleteByStudentId(@PathVariable int studentId){studentService.deleteByStudentId(studentId);}


}
