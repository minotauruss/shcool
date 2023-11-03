package com.ozkan.shcool.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;


public class StudentDto {

    private Long id;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(TeacherDto teacher) {
        this.teacher = teacher;
    }

    public TeacherDto getTeacher() {
        return teacher;
    }

    private String name;
    private TeacherDto teacher;

    public StudentDto(Long id, String name, TeacherDto teacher) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
    }


}
