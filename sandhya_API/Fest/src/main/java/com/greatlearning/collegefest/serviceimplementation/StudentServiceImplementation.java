package com.greatlearning.collegefest.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.collegefest.entity.Student;
import com.greatlearning.collegefest.repository.StudentRepository;
import com.greatlearning.collegefest.service.StudentService;

@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public void saveStudent(Student student) {
		studentRepository.saveAndFlush(student);
	}

	@Override
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}

	public Student findRegistration(int theId) {
		return studentRepository.findById(theId).get();
	}
}
