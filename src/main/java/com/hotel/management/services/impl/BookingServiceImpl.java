/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.services.impl;

import com.hotel.management.dao.BookingDao;
import com.hotel.management.entities.Booking;
import com.hotel.management.services.BookingService;
import java.util.List;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PAUL
 */
@Service("bookingService")
@Transactional
public class BookingServiceImpl implements BookingService {
 
    @Autowired
    private BookingDao dao;
     
    public Booking findById(int id) {
        return dao.findById(id);
    }
 
    public void save(Booking b) {
        dao.save(b);
    }
 
    public void update(Booking b) {
        Booking entity = dao.findById(b.getId());
        if(entity!=null){
            entity.setNumBooking(b.getNumBooking());
            entity.setDateBooking(b.getDateBooking());
            entity.setDateBegin(b.getDateBegin());
            entity.setDateEnd(b.getDateEnd());
            entity.setAmount(b.getAmount());
            entity.setClient(b.getClient());
            entity.setDel(b.isDel());
        }
    }
 
    public void deleteById(int id) {
        dao.deleteById(id);
    }
     
    public List<Booking> findAll() {
        return dao.findAll();
    }
     
    public List<Booking> findByDate(LocalDate date) {
        return dao.findByDate(date);
    }
 
    public Booking findOneByNum(String num) {
        return dao.findOneByNum(num);
    }
 
}
