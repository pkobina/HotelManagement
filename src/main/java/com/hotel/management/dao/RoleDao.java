/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.dao;

import com.hotel.management.entities.Role;
import java.util.List;

/**
 *
 * @author PAUL
 */
public interface RoleDao {
    Role findById(int id);
    
    void save(Role r);
    
    void deleteById(int id);
    
    List<Role> findAll();
    
    Role findOneByName(String name);
}
