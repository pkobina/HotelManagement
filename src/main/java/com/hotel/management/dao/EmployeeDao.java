/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.dao;

import com.hotel.management.entities.Employee;
import java.util.List;

/**
 *
 * @author PAUL
 */
public interface EmployeeDao {
    Employee findById(int id);
    
    void save(Employee emp);
    
    void deleteById(int id);
    
    List<Employee> findAll();
    
    Employee findOneByName(String name);
}
