package com.ozkan.shcool.controller;


import com.ozkan.shcool.dto.StudentDto;
import com.ozkan.shcool.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;
    public StudentController (StudentService studentService){
        this.studentService = studentService;
    }


    @PostMapping("/save")
    public String StudentSave (@RequestBody StudentDto studentDto){
        studentService.StudentSave(studentDto);
        return "student was saved";
    }

    @GetMapping("/students")
    public List<StudentDto> StudentsGet (){
        return  studentService.allStudentDtoGet();
    }


}
