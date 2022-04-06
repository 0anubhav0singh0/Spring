package com.example.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;

// we add @Controller annotation to this class because we need to make this class as a SpringMVC class to handle the request 
@Controller
public class StudentController {
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	// Handler method to handle list of students and return model and view
	//	makesure choose model from org.springframework.ui package
	@GetMapping("/students")
	public String listStudents(Model model) {
		// add data to the model 
		// key is "students" and value is we retrieve list of student from database 
		model.addAttribute("students", studentService.getAllStudents());
		// return view
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		// create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student",student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {       
		studentService.saveStudent(student);
//		 once user add student successfully the we need to redirect to students page
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		// get student from database by id 
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		// save updated student object 
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
	// handler method to handle delete student request
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id); 
		return "redirect:/students";
	}
	
}
