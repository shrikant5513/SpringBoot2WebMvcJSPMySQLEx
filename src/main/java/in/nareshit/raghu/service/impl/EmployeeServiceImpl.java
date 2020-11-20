package in.nareshit.raghu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.raghu.exception.EmployeeNotFoundException;
import in.nareshit.raghu.model.Employee;
import in.nareshit.raghu.repo.EmployeeRepository;
import in.nareshit.raghu.service.IEmployeeService;

@Service    //calculations,logics, TxManagement
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo; //HAS-A

	@Override
	public Integer saveEmployee(Employee e) {
		//calculations
		double esal = e.getEsal();
		double hra = esal * 20/100.0;
		double da = esal * 10/100.0;
		e.setHra(hra);
		e.setDa(da);
		//save employee
		e = repo.save(e);
		return e.getEid();
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public void deleteEmployee(Integer id) {
		Employee e = getOneEmployee(id);
		repo.delete(e);
		/*
		if(repo.existsById(id)) {
			repo.deleteById(id);
		} else {
			throw new EmployeeNotFoundException("Employee '"+id+"' Not Exist");
		}*/
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		Employee e = repo.findById(id)
				.orElseThrow(
						()-> new EmployeeNotFoundException("Employee '"+id+"' Not Exist")
						);
		return e;
		/*
		Optional<Employee> opt = repo.findById(id);
		if(opt.isPresent()) {
			Employee e = opt.get();
			return e;
		}else {
			throw new EmployeeNotFoundException("Employee '"+id+"' Not Exist");
		}*/
	}

	@Override
	public void updateEmployee(Employee e) {
		if(repo.existsById(e.getEid())) {
			//calculations
			double esal = e.getEsal();
			double hra = esal * 20/100.0;
			double da = esal * 10/100.0;
			e.setHra(hra);
			e.setDa(da);
			repo.save(e);
		} else {
			//throw EmployeeNotFoundException
		}
	}


}
