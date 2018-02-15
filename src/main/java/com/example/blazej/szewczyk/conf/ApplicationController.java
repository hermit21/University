package com.example.blazej.szewczyk.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.blazej.szewczyk.entity.Courses;
import com.example.blazej.szewczyk.repo.CoursesRepository;



@RestController
public class ApplicationController {
	
	@Autowired
	private CoursesRepository courseRepo;
	
	@GetMapping("/application/cli/show_courses/")
	public String displayAllCourse(Model model, @RequestParam(defaultValue="0") int page) {
		
		model.addAttribute("courses", courseRepo.findAll(new PageRequest(page, 4)) );
		
		return "rest/show_course";
	}
	
	@PostMapping("/application/cli/add_course")
	private void addCourse(@RequestBody Courses course) {
		
		courseRepo.save(course);
	}
	
	@PostMapping("/application/cli/delete_course/{id}")
	public void deleteCourse(@PathVariable Integer id) {
		
		courseRepo.delete(id);
	}
	
	@PostMapping("/application/cli/update_course/{id}")
	public void updateCourse(@RequestBody Courses course, @PathVariable Integer id) {
		Courses find_course = courseRepo.findOne(id);
		find_course.setCourse_name(course.getCourse_name());
		find_course.setDescription(course.getDescription());
		find_course.setInstructor(course.getInstructor());
		
		courseRepo.save(find_course);
		
	}
	

}
