/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.dao;

import com.hotel.management.entities.RoomType;
import java.util.List;

/**
 *
 * @author PAUL
 */
public interface RoomTypeDao {
    RoomType findById(int id);
    
    void save(RoomType rt);
    
    void deleteById(int id);
    
    List<RoomType> findAll();
    
    RoomType findOneByName(String name);
    
    RoomType findOneByPrice(double price);
}
