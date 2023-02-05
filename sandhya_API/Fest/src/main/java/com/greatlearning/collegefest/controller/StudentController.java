package com.greatlearning.collegefest.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.collegefest.entity.Student;
import com.greatlearning.collegefest.serviceimplementation.StudentServiceImplementation;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentServiceImplementation studentService;

	@RequestMapping("/")
	public String allRegistrations(Model theModel) {
		List<Student> allStudents = studentService.getAllStudents();
		// add to the spring model
		theModel.addAttribute("Students", allStudents);

		return "list-students";
	}

	@RequestMapping("/addRegistration")
	public String addNewRegistration(Model theModel) {
		Student student = new Student();
		theModel.addAttribute("Student", student);
		return "Registration-Form";
	}

	@RequestMapping("/updateDetails")
	public String updateRegistration(@RequestParam("id") int theId, Model theModel) {
		Student student = studentService.findRegistration(theId);
		theModel.addAttribute("Student", student);
		return "Registration-Form";
	}

	// delete saved data and reload all registration details
	@RequestMapping("/deleteDetails")
	public String deleteRegistration(@RequestParam("id") int theId) {
		studentService.deleteStudent(theId);
		return "redirect:/student/";
	}

	@PostMapping("/saveDetails")
	public String saveRegistrationDetails(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("course") String course,
			@RequestParam("country") String country) {
		Student student = new Student(id, firstName, lastName, course, country);
		studentService.saveStudent(student);
		return "redirect:/student/";
	}

	@RequestMapping(value = "/403")
	public ModelAndView accessDenied(Principal user) {

		ModelAndView model = new ModelAndView();
		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("Msg", "You dont have permission to access this page!");
		}
		model.setViewName("403");
		return model;
	}
}