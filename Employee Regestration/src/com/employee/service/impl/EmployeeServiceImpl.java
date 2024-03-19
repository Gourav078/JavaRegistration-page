package com.employee.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDAO;
import com.example.model.EmployeeForm;
import com.employee.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public EmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }
    
    

    @Override
    public boolean registerEmployee(EmployeeForm employee) {
        System.out.println("inside employee service");
//        System.out.println(getEmployeeDAO().ge);
    	boolean isRegistered = false;
        boolean saveEmployee = getEmployeeDAO().saveEmployee(employee);
        if (saveEmployee) {
            isRegistered = true;
        }
        return isRegistered;
    }

    @Override
    public EmployeeForm validateEmployeeCredential(String email, String password) {
        return getEmployeeDAO().getEmployeeByEmailAndPassword(email,  password);
    }
    @Override
    public List<EmployeeForm> getAllUsers() {
        return employeeDAO.getAllUsers();
    }
}
