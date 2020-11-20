package in.nareshit.raghu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.nareshit.raghu.exception.EmployeeNotFoundException;
import in.nareshit.raghu.model.Employee;
import in.nareshit.raghu.service.IEmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private IEmployeeService service; //HAS-A
	
	//1. Show Register Page
	@GetMapping("/register")
	public String showReg() {
		return "EmployeeReg";
	}
	
	
	//2. Save Employee Data
	@PostMapping("/save")
	public String saveEmp(
			@ModelAttribute Employee employee,
			Model model) 
	{
		//call service layer
		Integer eid = service.saveEmployee(employee);
		String message = " Employee '"+eid+"' saved ";
		model.addAttribute("msg", message);
		return "EmployeeReg";
	}
	
	//3. Fetch Data to UI
	@GetMapping("/all")
	public String showAllEmps(Model model) {
		//call service to fetch data
		List<Employee> list = service.getAllEmployees();
		//send to UI
		model.addAttribute("list", list);
		
		return "EmpData";
	}
	
	//4. Read id from URL and delete
	@GetMapping("/delete")
	public String removeEmp(
			@RequestParam Integer eid,
			Model model
			) 
	{
		try {
			//delete data based on Id
			service.deleteEmployee(eid);
			
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
			//throw back to FC
			throw e;
		}
		
		/*
		model.addAttribute("message", "Employee '"+eid+"' Deleted");
		//fetch latest data and display at UI
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmpData";*/
		return "redirect:all";
	}
	
	
	//5. Show Edit Page
	@GetMapping("/edit")
	public String showEdit(
			@RequestParam Integer eid,
			Model model)
	{
		
		try {
			//call service  method.
			Employee emp = service.getOneEmployee(eid);
			
			//send to UI for FORM DATA
			model.addAttribute("employee", emp);
			
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
			throw e;
		} 
		
		return "EmployeeEdit";
	}	
	
	//6. On click update method
	@PostMapping("/update")
	public String updateEmp(
			//read Form Data
			@ModelAttribute Employee employee
			) 
	{
		//call service
		service.updateEmployee(employee);
		//back to Data page
		return "redirect:all";
	}
	
	
	
	
}