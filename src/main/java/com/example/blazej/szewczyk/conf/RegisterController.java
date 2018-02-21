package com.example.blazej.szewczyk.conf;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.blazej.szewczyk.entity.Register;
import com.example.blazej.szewczyk.entity.Student;
import com.example.blazej.szewczyk.repo.StudentRepository;

@Controller
public class RegisterController {
	
	
	@Autowired
	StudentRepository studentRepo;

	@GetMapping("/register")
	public String registerAction(Model model) {
	
		model.addAttribute("register", new Register());
		
		return "register";
	}
	
	@PostMapping("/register")
	public String saveStudent(@ModelAttribute Register register ) {
		
			
			if(register.getPassword().matches(register.getRepeat_password())) {
				BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
				String hash_password = bCrypt.encode(register.getPassword());	
				
				Student student = new Student(register.getName(),register.getSurname(), register.getAddress(), register.getFaculty(), register.getSpecialization(), register.getUsername(), hash_password);
				studentRepo.save(student);
				System.out.println(hash_password);
				return "success";
			}
			 
		return "errors/error";
		
		
		
	}
	
}
