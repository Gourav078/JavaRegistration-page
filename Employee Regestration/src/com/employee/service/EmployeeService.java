package com.employee.service;
import java.util.List;

import com.example.model.EmployeeForm;

public interface EmployeeService {
    EmployeeForm validateEmployeeCredential(String email, String password);
    boolean registerEmployee(EmployeeForm employee);
	
    
    List<EmployeeForm> getAllUsers();

}
