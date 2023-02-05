package com.greatlearning.collegefest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.collegefest.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
