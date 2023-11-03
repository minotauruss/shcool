package com.ozkan.shcool.controller;

import com.ozkan.shcool.dto.TeacherDto;
import com.ozkan.shcool.exception.TeacherNotFound;
import com.ozkan.shcool.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService){
        this.teacherService=teacherService;
    }

    @PostMapping("/save")
    public String TeacherSave(@RequestBody TeacherDto teacherDto){
        teacherService.teacherSave(teacherDto);
        return "Teacher was saved";

    }

    @GetMapping("/teachers")
    public List<TeacherDto> TeachersGet() throws TeacherNotFound {
        return teacherService.allTeacherDtoGet();
    }
}
