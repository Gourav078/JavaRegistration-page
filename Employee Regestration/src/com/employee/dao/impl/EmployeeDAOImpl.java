package com.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.employee.dao.EmployeeDAO;
import com.example.model.EmployeeForm;

@Repository("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Override
    public boolean saveEmployee(EmployeeForm employee) {
    	System.out.println("inside save employee");
    	System.out.println(this.getHibernateTemplate());
    	int id = (Integer) hibernateTemplate.save(employee);
        
        return id > 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public EmployeeForm getEmployeeByEmailAndPassword(String email, String password) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(EmployeeForm.class);
        detachedCriteria.add(Restrictions.eq("email", email));
        detachedCriteria.add(Restrictions.eq("password", password));
        List<EmployeeForm> findByCriteria = (List<EmployeeForm>) hibernateTemplate.findByCriteria(detachedCriteria);
        return (findByCriteria != null && !findByCriteria.isEmpty()) ? findByCriteria.get(0) : null;
    }
    
    @Override
    public List<EmployeeForm> getAllUsers() {
        // Query all users from the database
        return hibernateTemplate.loadAll(EmployeeForm.class);
    }
}
