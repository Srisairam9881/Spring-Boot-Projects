package com.example.StudentMangementSystem.service;

import java.util.List;

import com.example.StudentMangementSystem.entity.studentData;

public interface StudentService {

	List<studentData> getAllStudents();
	
	studentData saveStudent(studentData student);
	
	studentData getStudentById(Long id);
	
	studentData updateStudent(studentData student);
	
	void deleteStudentById(Long id);
	
	
}
