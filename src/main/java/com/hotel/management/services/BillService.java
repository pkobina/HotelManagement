/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.services;

import com.hotel.management.entities.Bill;
import java.util.List;
import org.joda.time.LocalDate;

/**
 *
 * @author PAUL
 */
public interface BillService {
 
    Bill findById(int id);
     
    void save(Bill b);
     
    void update(Bill b);
     
    void deleteById(int id);
 
    List<Bill> findAll();
 
    List<Bill> findByDate(LocalDate date);  
     
    Bill findOneByNum(String num);
 
}
