package com.example.StudentMangementSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.StudentMangementSystem.entity.studentData;
import com.example.StudentMangementSystem.repositry.studentReposirty;

@Service
public class StudentServiceImpl implements StudentService {
    
	private studentReposirty studentReposirty;
	
	public StudentServiceImpl(com.example.StudentMangementSystem.repositry.studentReposirty studentReposirty) {
		super();
		this.studentReposirty = studentReposirty;
	}

	@Override
	public List<studentData> getAllStudents() {
		return studentReposirty.findAll();
	}

	@Override
	public studentData saveStudent(studentData student) {
		return studentReposirty.save(student);
	}

	@Override
	public studentData getStudentById(Long id) {
		return studentReposirty.findById(id).get();
	}

	@Override
	public studentData updateStudent(studentData student) {
		return studentReposirty.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentReposirty.deleteById(id);	
	}
	
	
	
}
