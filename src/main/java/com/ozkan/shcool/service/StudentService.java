package com.ozkan.shcool.service;

import com.ozkan.shcool.dto.StudentDto;
import com.ozkan.shcool.dto.StudentDtoFrom;
import com.ozkan.shcool.dto.TeacherDto;
import com.ozkan.shcool.model.Student;
import com.ozkan.shcool.model.Teacher;
import com.ozkan.shcool.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {

    private StudentDtoFrom studentDtoFrom;
    private StudentRepository studentRepository;

    public StudentService(StudentDtoFrom studentDtoFrom,StudentRepository studentRepository){
        this.studentRepository=studentRepository;
        this.studentDtoFrom=studentDtoFrom;
    }

    // the studentDto object sent is saved by repository(JPA) //
    public void StudentSave( StudentDto studentDto){
        Student student = studentDtoFrom.getStudentFrom(studentDto);
        studentRepository.save(student);
    }

    public List<StudentDto> allStudentDtoGet(){
        List<Student> students = new ArrayList<>();
        List<StudentDto> studentsDto = new ArrayList<>();
        students = studentRepository.findAll();

        for (Student student : students){

            studentsDto.add( studentDtoFrom.getStudentDtoFrom(student));
        }
        return studentsDto;


    }
}
