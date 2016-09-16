/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.dao;

import com.hotel.management.entities.Client;
import java.util.List;

/**
 *
 * @author PAUL
 */
public interface ClientDao {
    Client findById(int id);
    
    void save(Client c);
    
    void deleteById(int id);
    
    List<Client> findAll();
    
    Client findOneByName(String name);
    
    Client findOneByValidCod(String cod);
}
