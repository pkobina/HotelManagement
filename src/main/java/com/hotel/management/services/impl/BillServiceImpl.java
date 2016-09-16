/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.services.impl;

import com.hotel.management.dao.BillDao;
import com.hotel.management.entities.Bill;
import com.hotel.management.services.BillService;
import java.util.List;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PAUL
 */
@Service("billService")
@Transactional
public class BillServiceImpl implements BillService {
 
    @Autowired
    private BillDao dao;
     
    public Bill findById(int id) {
        return dao.findById(id);
    }
 
    public void save(Bill b) {
        dao.save(b);
    }
 
    public void update(Bill b) {
        Bill entity = dao.findById(b.getId());
        if(entity!=null){
            entity.setNumBill(b.getNumBill());
            entity.setDateBill(b.getDateBill());
            entity.setAmountBill(b.getAmountBill());
            entity.setDel(b.getDel());
        }
    }
 
    public void deleteById(int id) {
        dao.deleteById(id);
    }
     
    public List<Bill> findAll() {
        return dao.findAll();
    }
     
    public List<Bill> findByDate(LocalDate date) {
        return dao.findByDate(date);
    }
 
    public Bill findOneByNum(String num) {
        return dao.findOneByNum(num);
    }
 
}
