package com.example.blazej.szewczyk.conf;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.blazej.szewczyk.entity.Courses;
import com.example.blazej.szewczyk.entity.MyCourse;
import com.example.blazej.szewczyk.entity.Student;
import com.example.blazej.szewczyk.repo.CoursesRepository;
import com.example.blazej.szewczyk.repo.MyCourseRepository;

@Controller
@SessionAttributes("student_username")
public class DashboardController {
	
	@Autowired
	private CoursesRepository courseRepo;
	
	@Autowired
	private MyCourseRepository mycourseRepo;

	@GetMapping("/dashboard")
	public String panelStudenta(ModelMap modelMap) {
		
		if(modelMap.get("student_username").equals(null)) {
			return "redirect:/login";
		}
		
		return "dashboard";
	}
	
	@GetMapping("/dashboard/all_course")
	public String showAllCourse(Model model, @RequestParam(defaultValue="0") int page) {
		
		model.addAttribute("courses", courseRepo.findAll(new PageRequest(page, 5)));
		
		
		return "panel/catalog_course";
	}
	
	@GetMapping("/dashboard/all_course/{id}")
	public String addCourse(@PathVariable Integer id, ModelMap modelMap) {
		
		Courses course = courseRepo.findOne(id);
		String username = (String) modelMap.get("student_username");
		
		MyCourse myCourse = new MyCourse(course.getCourse_name(), course.getInstructor(), username, "pending");
		
		mycourseRepo.save(myCourse);
		
		return "panel/course_added";
	}
	
	@GetMapping("/dashboard/my_course/")
	public String myCourse(Model model, ModelMap modelMap, HttpServletRequest request) {
		
		String student_id = (String) modelMap.get("student_username");
		
		request.setAttribute("my_cours", mycourseRepo.findBy(student_id));
		
		
		return "panel/course_added";
	}
	
	@GetMapping("/dashboard/delete_course/{id}")
	public String deleteCoursFromList(@PathVariable Integer id) {
		
		mycourseRepo.delete(id);
		
		return "redirect:panel/catalog_course";
	}
	
}
