/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.services;

import com.hotel.management.entities.Employee;
import com.hotel.management.entities.Profile;
import java.util.List;

/**
 *
 * @author PAUL
 */
public interface ProfileService {
    Profile findById(int id);
    
    void save(Profile p);
    
    void deleteById(int id);
    
    List<Profile> findAll();
    
    List<Profile> findAllByEmployee(Employee e);
    
    Profile findOneByRule(String rule);
}
