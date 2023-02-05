package com.greatlearning.collegefest.service;

import java.util.List;

import com.greatlearning.collegefest.entity.Student;

public interface StudentService {

	void deleteStudent(int id);

	void saveStudent(Student student);

	List<Student> getAllStudents();
}
