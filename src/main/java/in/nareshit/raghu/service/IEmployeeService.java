package in.nareshit.raghu.service;

import java.util.List;

import in.nareshit.raghu.model.Employee;

public interface IEmployeeService {

	Integer saveEmployee(Employee e);
	List<Employee> getAllEmployees();
	void deleteEmployee(Integer id);
	
	Employee getOneEmployee(Integer id);
	void updateEmployee(Employee e);
}
