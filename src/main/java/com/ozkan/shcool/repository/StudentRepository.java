package com.ozkan.shcool.repository;

import com.ozkan.shcool.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
