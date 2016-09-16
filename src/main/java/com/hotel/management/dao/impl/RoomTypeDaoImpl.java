/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.dao.impl;

import com.hotel.management.dao.AbstractDao;
import com.hotel.management.dao.RoomTypeDao;
import com.hotel.management.entities.RoomType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PAUL
 */
@Repository("roomtypeDao")
public class RoomTypeDaoImpl extends AbstractDao<Integer, RoomType> implements RoomTypeDao {
 
    public RoomType findById(int id) {
        return getByKey(id);
    }
 
    public void save(RoomType rt) {
        persist(rt);
    }
 
    public void deleteById(int id) {
        Query query = getSession().createSQLQuery("delete from RoomType where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<RoomType> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<RoomType>) criteria.list();
    }
 
    public RoomType findOneByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nameType", name));
        return (RoomType) criteria.uniqueResult();
    }
 
    public RoomType findOneByPrice(double price) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("priceType", price));
        return (RoomType) criteria.uniqueResult();
    }
}
