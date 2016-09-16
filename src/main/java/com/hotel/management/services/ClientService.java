/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.services;

import com.hotel.management.entities.Client;
import java.util.List;

/**
 *
 * @author PAUL
 */
public interface ClientService {
 
    Client findById(int id);
     
    void save(Client c);
     
    void update(Client c);
     
    void deleteById(int id);
 
    List<Client> findAll(); 
     
    Client findOneByName(String name);
 
    boolean isClientUnique(Integer id, String name);
}
