package com.employee.controllers;

import javax.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.EmployeeForm;
import com.employee.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage() {
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		model.addAttribute("employeeForm", new EmployeeForm());
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage(Model model) {
		model.addAttribute("employeeForm", new EmployeeForm());
		return "register";
	}

	@RequestMapping(value = "registerSuccess", method = RequestMethod.POST)
	public ModelAndView registerSuccess(@Valid @ModelAttribute("employeeForm") EmployeeForm employeeForm,
			BindingResult bindingResult) {
		System.out.println("inside register success");
		ModelAndView modelAndView = new ModelAndView("login");
		System.out.println(bindingResult.getFieldValue("dateOfBirth"));
		System.out.println(bindingResult);
		try {
			if (bindingResult.hasErrors()) {
				return new ModelAndView("register");
			}
			getEmployeeService().registerEmployee(employeeForm);
			modelAndView.addObject("employeeForm", employeeForm);

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return modelAndView;
	}

	/*
	 * @RequestMapping(value = "/registerSuccess", method = RequestMethod.POST)
	 * public String register(@Valid @ModelAttribute("employeeForm") EmployeeForm
	 * employeeForm, BindingResult bindingResult, Model model) { if
	 * (bindingResult.hasErrors()) { return "register"; }
	 * getEmployeeService().registerEmployee(employeeForm); // Redirect to prevent
	 * duplicate form submission return "redirect:/welcome"; }
	 */

	@RequestMapping(value = "loginSuccess", method = RequestMethod.POST)
	public ModelAndView loginSuccess(@Valid @ModelAttribute("employeeForm") EmployeeForm employeeForm,
			BindingResult bindingResult) {
		System.out.println("inside login");

		ModelAndView modelAndView = new ModelAndView("welcome");
		System.out.println(bindingResult);
		try {
			if (bindingResult.hasErrors()) {
				return new ModelAndView("login");
			}
			
			
			EmployeeForm employee = getEmployeeService().validateEmployeeCredential(employeeForm.getEmail(),
					employeeForm.getPassword());
			 System.out.println(employee);
			if (employee != null) {
				modelAndView.addObject("message", "Hello " + employee.getName());
				employeeForm.setName(employee.getName()) ;
				System.out.println("Name: " + employee.getName());
				 List<EmployeeForm> allUsers = getEmployeeService().getAllUsers();
				 System.out.println("All Users: " + allUsers);
		            // Add the list of users to the model
		            modelAndView.addObject("allUsers", allUsers);
			} else {
				modelAndView = new ModelAndView("notfound");
			}

		} catch (Exception err) {
			System.out.println(err);
		}
		return modelAndView;
	}

//	@RequestMapping(value = "loginSuccess", method = RequestMethod.POST)
//	public ModelAndView loginSuccess(@Valid @ModelAttribute("employeeForm") EmployeeForm employeeForm,
//	        BindingResult bindingResult) {
//	    ModelAndView modelAndView = new ModelAndView("welcome");
//	    System.out.println(bindingResult);
//	    try {
//	        if (bindingResult.hasErrors()) {
//	            // If there are validation errors, return to the login page with error messages
//	            return new ModelAndView("login");
//	        }
//
//	        // Validate employee credentials
//	        EmployeeForm employee = getEmployeeService().validateEmployeeCredential(employeeForm.getEmail(),
//	                employeeForm.getPassword());
//	        if (employee != null) {
//	            modelAndView.addObject("message", "Hello " + employee.getName());
//	            System.out.println("Login success");
//	        } else {
//	            modelAndView = new ModelAndView("notFound");
//	        }
//
//	    } catch (Exception err) {
//	        System.out.println(err);
//	    }
//	    return modelAndView;
//	}
//}

	@GetMapping("/logout")
	public String logout() {
		return "redirect:/login";
	}

	@ModelAttribute
	public void headerMessage(Model model) {
		model.addAttribute("headerMessage", "Welcome");
	}
	@ModelAttribute
	public void UserMessage(Model model) {
		model.addAttribute("userMessage", "Hello");
	}
}
