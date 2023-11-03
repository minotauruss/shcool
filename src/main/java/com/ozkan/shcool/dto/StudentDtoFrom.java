package com.ozkan.shcool.dto;

import com.ozkan.shcool.model.Student;
import com.ozkan.shcool.model.Teacher;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class StudentDtoFrom {

private TeacherDtoFrom teacherDtoFrom;

public  StudentDtoFrom ( @Lazy TeacherDtoFrom teacherDtoFrom){
    this.teacherDtoFrom = teacherDtoFrom;
}

    public StudentDto getStudentDtoFrom (Student student){

    TeacherDto teacherDto = teacherDtoFrom.getTeacherDtoFrom(student.getTeacher());

        return new StudentDto(student.getId(), student.getName(), teacherDto);
    }


    public Student getStudentFrom( StudentDto from){

        Teacher teacher = teacherDtoFrom.getTeacherFrom(from.getTeacher());
     return  new Student(from.getId(),from.getName(),teacher);
    }
}
