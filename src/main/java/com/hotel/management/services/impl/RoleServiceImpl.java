/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.services.impl;

import com.hotel.management.dao.RoleDao;
import com.hotel.management.entities.Role;
import com.hotel.management.services.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PAUL
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
 
    @Autowired
    private RoleDao dao;
     
    public Role findById(int id) {
        return dao.findById(id);
    }
 
    public void save(Role r) {
        dao.save(r);
    }
 
    public void update(Role r) {
        Role entity = dao.findById(r.getId());
        if(entity!=null){
            entity.setNameRole(r.getNameRole());
            entity.setDescRole(r.getDescRole());
            entity.setDel(r.isDel());
        }
    }
 
    public void deleteById(int id) {
        dao.deleteById(id);
    }
     
    public List<Role> findAll() {
        return dao.findAll();
    }
 
    public Role findOneByName(String name) {
        return dao.findOneByName(name);
    }
 
}
