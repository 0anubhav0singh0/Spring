package com.springboot.controller;

import java.util.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.dao.PatientDAO;
import com.springboot.domain.Patient;

@RestController
public class PatientController {
	@Autowired
	PatientDAO patientdao;
	/*
	This method calls the list method of PatientDAO class and get the 
	list of patients and returns the list of patient objects.
	*/
	@RequestMapping(value = "/patient/list", method = RequestMethod.GET)
	// @GetMapping("/patient/list")
	List<Patient> listPatients(){
		List<Patient> plist = patientdao.getPatients();
		return plist;
	}

	/*
	This method gets an object of type Patient as an argument 
	through the request body and calls the create method of 
	PatientDAO and returns the patient object which is returned 
	by the create method of PatientDAO class as a JSON response.
	*/
	@RequestMapping(value = "/patient/create", method = RequestMethod.POST)
	// @PostMapping("/patient/create")
	List<Patient> createPatient(@RequestBody Patient patient){
		List<Patient> clist = patientdao.createPatient(patient);
		return clist;
	}
}
