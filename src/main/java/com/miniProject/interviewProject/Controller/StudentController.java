package com.miniProject.interviewProject.Controller;

import com.miniProject.interviewProject.Entities.Student;
import com.miniProject.interviewProject.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public List<Student> findStudentByPhoneNumber(@PathVariable String phoneNumber){return studentService.findStudentByPhoneNumber(phoneNumber);}

    @GetMapping("/findByIdentityNo/{identityNumber}")
    public List<Student> findStudentByIdentityNumber(@PathVariable String identityNumber){return studentService.findStudentByIdentityNumber(identityNumber);}

    @GetMapping("/findByName/{studentName}")
    public List<Student> findStudentByStudentName(@PathVariable String studentName){return studentService.findStudentByName(studentName);}

    @GetMapping("/findByCityId/{cityId}")
    public List<Student> findStudentByCityId(@PathVariable int cityId){return studentService.findStudentByCityId(cityId);}

    @GetMapping("/findByTownId/{townId}")
    public List<Student> findStudentByTownId(@PathVariable int townId){return studentService.findStudentByTownId(townId);}


    @GetMapping("/findAll")
    public List<Student> findAll(){return studentService.findAll();}

    @PostMapping("/deleteByStudentId/{studentId}")
    public void deleteByStudentId(@PathVariable int studentId){studentService.deleteByStudentId(studentId);}

}
