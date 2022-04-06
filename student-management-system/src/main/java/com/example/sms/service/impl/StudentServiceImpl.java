package com.example.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sms.entity.Student;
import com.example.sms.repository.StudentRepository;
import com.example.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	// Just Remember whenever the spring bean has only one constructor then avoid using @Autowired
	private StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		// .findAll() basically return a list of Student
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		System.out.println(studentRepository.findById(id));
//		findById() returns null if record does not exist
//		The findById() method is used to retrieves an entity by its id and it is available in CrudRepository interface. 
//		The return value is Optional<T>
//		 Optional is a class introduced in java 8
		return studentRepository.findById(id).get();
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
	}

}
