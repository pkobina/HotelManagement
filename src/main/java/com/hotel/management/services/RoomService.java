/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.services;

import com.hotel.management.entities.Room;
import java.util.List;

/**
 *
 * @author PAUL
 */
public interface RoomService {
 
    Room findById(int id);
     
    void save(Room r);
     
    void update(Room r);
     
    void deleteById(int id);
 
    List<Room> findAll();  
 
    List<Room> findByLocation(String location); 
     
    Room findOneByNum(String num);
 
}
