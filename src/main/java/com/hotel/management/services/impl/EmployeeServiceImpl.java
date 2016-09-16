/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.services.impl;

import com.hotel.management.dao.EmployeeDao;
import com.hotel.management.entities.Employee;
import com.hotel.management.services.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PAUL
 */
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
 
    @Autowired
    private EmployeeDao dao;
     
    public Employee findById(int id) {
        return dao.findById(id);
    }
 
    public void save(Employee e) {
        dao.save(e);
    }
 
    public void update(Employee e) {
        Employee entity = dao.findById(e.getId());
        if(entity!=null){
            entity.setName(e.getName());
            entity.setPhone(e.getPhone());
            entity.setAddress(e.getAddress());
            entity.setEmail(e.getEmail());
            entity.setSexe(e.getSexe());
            entity.setDob(e.getDob());
            entity.setHiredDate(e.getHiredDate());
        }
    }
 
    public void deleteById(int id) {
        dao.deleteById(id);
    }
     
    public List<Employee> findAll() {
        return dao.findAll();
    }
 
    public Employee findOneByName(String name) {
        return dao.findOneByName(name);
    }
 
    public boolean isEmployeeUnique(Integer id, String name) {
        Employee e = findOneByName(name);
        return ( e == null || ((id != null) && (e.getId() == id)));
    }
}
