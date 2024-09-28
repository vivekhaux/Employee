package com.employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Entity.empEntity;
import com.employee.Service.empService;


@RestController
@RequestMapping(value="/Employee")
public class empController {
	
	@Autowired
	empService es;
	
	//Using post mapping with entity class
	@PostMapping(value="/postEmployee")
	public String postThis(@RequestBody empEntity e) {
		return es.postThis(e);
	}
	
	//Using post mapping and save all
	@PostMapping(value="/postEmp")
    public String postEmp(@RequestBody List<empEntity> a) {
		return es.postEmp(a);
	}
	
	//Using get mapping with find all
	@GetMapping(value="/getEmp")
	public List<empEntity> getEmp() {
		return es.getEmp();
	}
	
	//Using get mapping with controller and service take the name with map method 
	@GetMapping(value="/getmaleEmp")
	public List<String> getmale() {
		return es.getmale();
	}
	
	//Using get mapping find highest salary with full object
	@GetMapping(value="/getsalaryEmp")
	public int getsalaryEmp() {
		return es.getsalaryEmp();
	}
	
	//Using get mapping find the max salary with full object
	@GetMapping(value="/getMaxSalaryEmp")
	public empEntity getMaxSalaryEmp() {
		return es.getMaxSalaryEmp();
	}
	
	//Using get mapping find the average of salary
	@GetMapping(value="/getAvgSalaryEmp") 
	public double getAvgSalaryEmp() {
		return es.getAvgSalaryEmp();
	}
	
	//Using get mapping find the name starts with v and salary should be greater than 300000
	@GetMapping(value="/getNameSalEmp")
	public List<empEntity> getNameSalEmp() {
		return es.getNameSalEmp();
	}
	
	//Using get mapping find the name in sorted method
	@GetMapping(value="/getSortNameEmp")
	public List<empEntity> getSortNameEmp() {
		return es.getSortNameEmp();
	}
	
	//Using get mapping find the count with experience greater than 4
	@GetMapping(value="/getExpCountEmp")
	public Long getExpCountEmp() {
		return es.getExpCountEmp();
	}
	
	//Using get mapping find the count with field and use map method
	@GetMapping(value="/getFieldCountEmp")
	public Long getFieldCountEmp() {
		return es.getFieldCountEmp();
	}
	
	//Using with query name and in repository query is used
	@GetMapping(value="/queryEmp/{a}")
	public List<empEntity> getByName(@PathVariable String a) {
		return es.getByName(a);
	}
	
	//Using with query salary 
	@GetMapping(value="/querySalEmp/{a}/{b}")
	public List<empEntity> getBySalary(@PathVariable int a, @PathVariable int b) {
		return es.getBySalary(a,b);
	}
	
	//Using J query with name 
	@GetMapping(value="/queryNameEmp/{b}")
	public List<empEntity> getByEmpName(@PathVariable String a) {
		return es.getByEmpName(a);
	}
	
	//Using with or operator in native query with salary
	@GetMapping(value="/queryNameEmp1/{a}/{b}")
	public List<empEntity> getByEmpName1(@PathVariable char a, @PathVariable char b) {
		return es.getByEmpName1(a,b);
	}
}
