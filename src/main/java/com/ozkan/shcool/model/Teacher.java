package com.ozkan.shcool.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Table
public class Teacher {
    public Long getId() {
        return id;
    }


    public Teacher(Long id, String name, List<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Student> students;

    // Getter ve Setter metotları
}