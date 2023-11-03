package com.ozkan.shcool.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



public class TeacherDto {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public List<StudentDto> getStudents() {
        return students;
    }

    private String name;



    private List<StudentDto> students;

    public TeacherDto(Long id, String name, List<StudentDto> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }
}
