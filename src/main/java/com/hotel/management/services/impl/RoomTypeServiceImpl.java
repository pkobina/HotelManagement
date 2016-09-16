/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.services.impl;

import com.hotel.management.dao.RoomTypeDao;
import com.hotel.management.entities.RoomType;
import com.hotel.management.services.RoomTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PAUL
 */
@Service("roomtypeService")
@Transactional
public class RoomTypeServiceImpl implements RoomTypeService {
 
    @Autowired
    private RoomTypeDao dao;
     
    public RoomType findById(int id) {
        return dao.findById(id);
    }
 
    public void save(RoomType rt) {
        dao.save(rt);
    }
 
    public void update(RoomType rt) {
        RoomType entity = dao.findById(rt.getId());
        if(entity!=null){
            entity.setNameType(rt.getNameType());
            entity.setDescTye(rt.getDescTye());
            entity.setPriceType(rt.getPriceType());
            entity.setDel(rt.isDel());
        }
    }
 
    public void deleteById(int id) {
        dao.deleteById(id);
    }
     
    public List<RoomType> findAll() {
        return dao.findAll();
    }
 
    public RoomType findOneByName(String name) {
        return dao.findOneByName(name);
    }
 
    public RoomType findOneByPrice(double price) {
        return dao.findOneByPrice(price);
    }
 
}
