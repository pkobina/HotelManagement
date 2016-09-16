/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.services.impl;

import com.hotel.management.dao.ProfileDao;
import com.hotel.management.entities.Employee;
import com.hotel.management.entities.Profile;
import com.hotel.management.services.ProfileService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PAUL
 */
@Service("profileService")
@Transactional
public class ProfileServiceImpl implements ProfileService {
 
    @Autowired
    private ProfileDao dao;
     
    public Profile findById(int id) {
        return dao.findById(id);
    }
 
    public void save(Profile p) {
        dao.save(p);
    }
 
    public void update(Profile p) {
        Profile entity = dao.findById(p.getId());
        if(entity!=null){
            entity.setIsGranted(p.isIsGranted());
            entity.setNumProfil(p.getNumProfil());
            entity.setRule(p.getRule());
        }
    }
 
    public void deleteById(int id) {
        dao.deleteById(id);
    }
     
    public List<Profile> findAll() {
        return dao.findAll();
    }
     
    public List<Profile> findAllByEmployee(Employee e) {
        return dao.findAllByEmployee(e);
    }
 
    public Profile findOneByRule(String rule) {
        return dao.findOneByRule(rule);
    }
 
}
