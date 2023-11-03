package com.ozkan.shcool.dto;


import com.ozkan.shcool.model.Student;
import com.ozkan.shcool.model.Teacher;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherDtoFrom {
private StudentDtoFrom studentDtoFrom;

public TeacherDtoFrom(  @Lazy StudentDtoFrom studentDtoFrom){
    this.studentDtoFrom = studentDtoFrom;
}

    public TeacherDto getTeacherDtoFrom (Teacher  from ){
        List<StudentDto> students = new ArrayList<>();
        for ( Student student : from.getStudents()){
             students.add(studentDtoFrom.getStudentDtoFrom(student));

        }

        return new TeacherDto(from.getId(), from.getName(),students);
    }


    public Teacher getTeacherFrom ( TeacherDto from){
        List<Student> students = new ArrayList<>();
        for ( StudentDto student : from.getStudents()){
            students.add(studentDtoFrom.getStudentFrom(student));

        }

    return new Teacher(from.getId(),from.getName(),students);
    }

}
