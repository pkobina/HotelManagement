/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.services.impl;

import com.hotel.management.dao.ClientDao;
import com.hotel.management.entities.Client;
import com.hotel.management.services.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PAUL
 */
@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {
 
    @Autowired
    private ClientDao dao;
     
    public Client findById(int id) {
        return dao.findById(id);
    }
 
    public void save(Client c) {
        dao.save(c);
    }
 
    public void update(Client c) {
        Client entity = dao.findById(c.getId());
        if(entity!=null){
            entity.setName(c.getName());
            entity.setPhone(c.getPhone());
            entity.setAddress(c.getAddress());
            entity.setEmail(c.getEmail());
            entity.setSexe(c.getSexe());
            entity.setIdentityDoc(c.getIdentityDoc());
            entity.setNumDoc(c.getNumDoc());
        }
    }
 
    public void deleteById(int id) {
        dao.deleteById(id);
    }
     
    public List<Client> findAll() {
        return dao.findAll();
    }
 
    public Client findOneByName(String name) {
        return dao.findOneByName(name);
    }
 
    public boolean isClientUnique(Integer id, String name) {
        Client e = findOneByName(name);
        return ( e == null || ((id != null) && (e.getId() == id)));
    }
}
