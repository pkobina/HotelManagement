/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.services.impl;

import com.hotel.management.dao.RoomDao;
import com.hotel.management.entities.Room;
import com.hotel.management.services.RoomService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PAUL
 */
@Service("roomService")
@Transactional
public class RoomServiceImpl implements RoomService {
 
    @Autowired
    private RoomDao dao;
     
    public Room findById(int id) {
        return dao.findById(id);
    }
 
    public void save(Room r) {
        dao.save(r);
    }
 
    public void update(Room r) {
        Room entity = dao.findById(r.getId());
        if(entity!=null){
            entity.setNumRoom(r.getNumRoom());
            entity.setLocation(r.getLocation());
            entity.setRoomType(r.getRoomType());
            entity.setDel(r.isDel());
        }
    }
 
    public void deleteById(int id) {
        dao.deleteById(id);
    }
     
    public List<Room> findAll() {
        return dao.findAll();
    }
     
    public List<Room> findByLocation(String location) {
        return dao.findByLocation(location);
    }
 
    public Room findOneByNum(String num) {
        return dao.findOneByNum(num);
    }
 
}
