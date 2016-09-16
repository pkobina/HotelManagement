/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.dao.impl;

import com.hotel.management.dao.AbstractDao;
import com.hotel.management.dao.RoomDao;
import com.hotel.management.entities.Room;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PAUL
 */
@Repository("roomDao")
public class RoomDaoImpl extends AbstractDao<Integer, Room> implements RoomDao {
 
    public Room findById(int id) {
        return getByKey(id);
    }
 
    public void save(Room r) {
        persist(r);
    }
 
    public void deleteById(int id) {
        Query query = getSession().createSQLQuery("delete from Room where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<Room> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Room>) criteria.list();
    }
 
    @SuppressWarnings("unchecked")
    public List<Room> findByLocation(String location) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("location", location));
        return (List<Room>) criteria.list();
    }
 
    public Room findOneByNum(String num) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("numRoom", num));
        return (Room) criteria.uniqueResult();
    }
}
