package com.example.blazej.szewczyk.conf;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.blazej.szewczyk.entity.Login;
import com.example.blazej.szewczyk.entity.Student;
import com.example.blazej.szewczyk.repo.StudentRepository;


@Controller
@SessionAttributes("student_username")
public class HomeController {
	
	@Autowired
	StudentRepository studentRepo;
	
	@GetMapping("/")
	public String homeAction() {
		
		return "home";
		
	}
	
	
	@GetMapping("/login")
	public String loginAction(Model model) {
		model.addAttribute("login", new Login());
		
		return "index";
	}
	
	@PostMapping("/login")
	public String zalogujStudent(@ModelAttribute Login login, ModelMap map) {
 
		Student student = studentRepo.findByUsername(login.getUsername());
		
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		System.out.println(bCrypt.matches(login.getPassword(), student.getPassword()));
		if(bCrypt.matches(login.getPassword(), student.getPassword())) {
			
			
			map.put("student_username", student.getUsername());
			
			System.out.println(map.get("student_username"));
			return "redirect:/dashboard";
		}
		
		return "index";
	}
	
	
	
	
}
