package com.repository; 


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Employee;


public interface EmployeeRepository extends JpaRepository <Employee, Integer>{
	
	List<Employee>findByEmailAndPassword(String email, String password);
	List<Employee>findByIdEmployeeAndJobInterviews_idJobInterviewOrderByJobInterviews_Date(Integer idEmployee, Integer idJobInterview);
   
}
