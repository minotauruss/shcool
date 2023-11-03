package com.ozkan.shcool.service;

import com.ozkan.shcool.dto.TeacherDto;
import com.ozkan.shcool.dto.TeacherDtoFrom;
import com.ozkan.shcool.exception.TeacherNotFound;
import com.ozkan.shcool.model.Teacher;
import com.ozkan.shcool.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    private TeacherRepository teacherRepository;
    private TeacherDtoFrom teacherDtoFrom;

    public TeacherService (TeacherRepository teacherRepository,TeacherDtoFrom teacherDtoFrom ){
        this.teacherRepository = teacherRepository;
        this.teacherDtoFrom = teacherDtoFrom;
    }


    // the teacherDto object sent is saved by repository(JPA) //
    public void teacherSave ( TeacherDto teacherDto){

        Teacher teacher = teacherDtoFrom.getTeacherFrom(teacherDto);
        teacherRepository.save(teacher);

    }

    // all teachers' entity is converted to teacherDto & then we collect in a list to return //
    public List<TeacherDto> allTeacherDtoGet() throws TeacherNotFound {
        List<Teacher> teachers = new ArrayList<>();
        List<TeacherDto> teachersDto = new ArrayList<>();
        teachers = teacherRepository.findAll();

        for (Teacher teacher : teachers){
            teacherDtoFrom.getTeacherDtoFrom(teacher);
            teachersDto.add( teacherDtoFrom.getTeacherDtoFrom(teacher));
        }
        return teachersDto;


    }
}
