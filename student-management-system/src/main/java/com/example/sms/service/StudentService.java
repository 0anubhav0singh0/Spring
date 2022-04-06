package com.example.sms.service;

import java.util.List;

import com.example.sms.entity.Student;

//inorder to loose couple all the dependencies we are gone use interface and create a class to implement it 
public interface StudentService{
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	Student getStudentById(Long id);
	Student updateStudent(Student student);
	void deleteStudentById(Long id);
}
