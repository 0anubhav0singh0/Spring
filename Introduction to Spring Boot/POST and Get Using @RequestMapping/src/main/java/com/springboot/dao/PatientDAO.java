package com.springboot.dao;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


import com.springboot.domain.Patient;

@Component
public class PatientDAO {
	
	static List<Patient> patientList = new ArrayList<>(); 
	
	static {
			patientList.add(new Patient(1L, "Swathy", "9876567234", "swathy@gmail.com", "31-07-1989"));
			patientList.add(new Patient(2L, "Vanmathi", "9873877234", "vanmathi@gmail.com", "23-04-1992"));
			patientList.add(new Patient(3L, "Kevin", "9823641234", "kevin@gmail.com", "01-04-2000"));
	}
	
	/*
	This method accepts a patient object and adds it to the 
	patient list and returns the new list
	*/
	public List<Patient> createPatient(Patient p){
		//Fill the code
		patientList.add(p);
		return PatientDAO.patientList;
	}
	
	/*
	This method is used to return patient list and the patient 
	details are already preloaded in the template code.
	*/
	public List<Patient> getPatients(){
		//Fill the code
		return PatientDAO.patientList;
	}
	
}
