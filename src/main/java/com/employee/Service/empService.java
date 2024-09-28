package com.employee.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee.DAO.empDAO;
import com.employee.Entity.empEntity;

@Service
public class empService {
	@Autowired
	empDAO ed;
	
	//using with post mapping
	public String postThis(empEntity e) {
		return ed.postThis(e);
	}
	
	public String postEmp(List<empEntity> a) {
		return ed.postEmp(a);
	}
	
	public List<empEntity> getEmp() {
		return ed.getEmp();
	}
	 
	public List<String> getmale() {
		List<empEntity> emps = ed.getEmp();
		List<String> emps1 = emps.stream().map(x->x.getName()).collect(Collectors.toList());
		return emps1;
		}
	    
	public int getsalaryEmp() {
		List<empEntity> empSalary = ed.getEmp();
		int empSal = empSalary.stream().map(x->x.getAge()).collect(Collectors.summingInt(Integer::intValue));
		return empSal;
	}
	
	public empEntity getMaxSalaryEmp() {
		List<empEntity> maxSalary = ed.getEmp();
		empEntity maxSal = maxSalary.stream().max(Comparator.comparing(empEntity::getSalary)).get();
		return maxSal;
	}
	
	public double getAvgSalaryEmp() {
		List<empEntity> avgSalary = ed.getEmp();
		double avgSal = avgSalary.stream().collect(Collectors.averagingInt(x->x.getSalary()));
		return avgSal;
	}
	
	public List<empEntity> getNameSalEmp() {
		List<empEntity> getName = ed.getEmp();
		List<empEntity> getNameSal = getName.stream().filter(x->x.getName().startsWith("V") && x.getSalary()
				> 300000).collect(Collectors.toList());
		return  getNameSal;			
	}
	
	public List<empEntity> getSortNameEmp() {
		List<empEntity> getSort = ed.getEmp();
		List<empEntity> nameSort = getSort.stream().sorted(Comparator.comparing(empEntity::getName)).collect
					(Collectors.toList());
		return nameSort;
	}
	
	public Long getExpCountEmp() {
		List<empEntity> expCount = ed.getEmp();
		Long getCount = expCount.stream().filter(x->x.getExperience() > 4).count();
		return getCount;
	}
	
	public Long getFieldCountEmp() {
		List<empEntity> fieldCount = ed.getEmp();
		Long getFieldCount = fieldCount.stream().map(x->x.getField()).count();
		return getFieldCount;
	}
	
	//Using query with brand
	public List<empEntity> getByName(@PathVariable String a) {
		return ed.getByName(a);
	}
	
	//Using query with salary
	public List<empEntity> getBySalary(@PathVariable int a, @PathVariable int b) {
		return ed.getBySalary(a,b);
	}
	
	//Using J query with name
	public List<empEntity> getByEmpName(@PathVariable String a) {
		return ed.getByEmpName(a);
	}
	
	//Using native query with V% and with name 
	public List<empEntity> getByEmpName1(@PathVariable char a, @PathVariable char b) {
		return ed.getByEmpName1(a,b); 
	}
}
	

