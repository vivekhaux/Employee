package com.employee.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.Entity.empEntity;

public interface empRepository extends JpaRepository<empEntity, Integer> {
	
	    //This is native query or SQL query
        @Query(value="select * from employee_table where name=?",nativeQuery=true)
		public List<empEntity> getByName (String a);
		
		@Query(value="select * from employee_table where salary>? && salary<?",nativeQuery=true)
		public List<empEntity> getBySalary (int a, int b);
		
		//This is using J-query
		@Query(value="select e from empEntity e where e.name=:p")
		public List<empEntity> getByEmpName(@Param ("p") String a);
		
		//This is using native query 
		@Query(value="select * from employee_table where name like ?% Or name like ?%",nativeQuery=true)
		public List<empEntity> getByEmpName1(char a, char b);
}
