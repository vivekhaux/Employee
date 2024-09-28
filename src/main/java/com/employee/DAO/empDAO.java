package com.employee.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.Entity.empEntity;
import com.employee.Repository.empRepository;

@Repository
public class empDAO {
	@Autowired
	empRepository er;
	
	
	public String postThis(empEntity e) {
		er.save(e);
		return "Posted Success";
	}
	
	public String postEmp(List<empEntity> a) {
		er.saveAll(a);
		return "Posted Success";
	}
	
	public List<empEntity> getEmp() {
		return er.findAll();
	}
	
	//using Query name with brand
	public List<empEntity> getByName(String a) {
		return er.getByName(a);
	}
	
	//using query with salary
	public List<empEntity> getBySalary(int a, int b) {
		return er.getBySalary(a,b);
	}
	
	//Using J query with name
	public List<empEntity> getByEmpName(String a) {
		return er.getByEmpName(a);
	}
	
	//Using native query with name using V%
	public List<empEntity> getByEmpName1(char a, char b) {
		return er.getByEmpName1(a,b);
	}
}
