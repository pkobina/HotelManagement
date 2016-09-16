/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.services;

import com.hotel.management.entities.Booking;
import java.util.List;
import org.joda.time.LocalDate;

/**
 *
 * @author PAUL
 */
public interface BookingService {
 
    Booking findById(int id);
     
    void save(Booking b);
     
    void update(Booking b);
     
    void deleteById(int id);
 
    List<Booking> findAll();
 
    List<Booking> findByDate(LocalDate date);  
     
    Booking findOneByNum(String num);
 
}
