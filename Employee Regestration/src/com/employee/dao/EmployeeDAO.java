package com.employee.dao;
import java.util.List;
import com.example.model.EmployeeForm;

public interface EmployeeDAO {
    boolean saveEmployee(EmployeeForm employee);
    EmployeeForm getEmployeeByEmailAndPassword(String email, String password);
    
    List<EmployeeForm> getAllUsers();
}
