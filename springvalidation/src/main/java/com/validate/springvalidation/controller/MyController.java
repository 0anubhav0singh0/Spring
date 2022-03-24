package com.validate.springvalidation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.validate.springvalidation.entities.LoginData;

@Controller
public class MyController {
	
	@GetMapping("/form")
	public String openForm(Model model) {
		// jab controller me form bhej rahe hai usi samaye ham iss apne object ka loginData ka ek empty instance de denge jise ki form data ko object ke saath bind kar paye
		model.addAttribute("loginData", new LoginData());
		return "form";
	}
	
	// handler for process form
	// validation trigger karne ke liye jaha hamne @ModelAttribute attribute liya hai use pehle likhna padega @Valid
	// @Valid nahi lagaya to validation trigger nahi honge or jo iska result hoga validation ka wo aake ek object me aa jayega jiska naame hota hai BindingResult (jo ki aa raha hamara org.springframework.validation se)
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult result ) {
		// @ModelAttribute ki help se hamlog jo bhi object data isme aa raha hoga usko utha ke ek variable me daal denge
		// hasError() boolean value return karega 
		if(result.hasErrors()) {
			System.out.println(result);
			return "form";
		}
		System.out.println(loginData);
		return "success";
	}
}
