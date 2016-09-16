/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.dao.impl;

import com.hotel.management.dao.AbstractDao;
import com.hotel.management.dao.EmployeeDao;
import com.hotel.management.entities.Employee;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PAUL
 */
@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {
 
    public Employee findById(int id) {
        return getByKey(id);
    }
 
    public void save(Employee employee) {
        persist(employee);
    }
 
    public void deleteById(int id) {
        Query query = getSession().createSQLQuery("delete from Employee where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<Employee> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Employee>) criteria.list();
    }
 
    public Employee findOneByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (Employee) criteria.uniqueResult();
    }
}
