/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.dao.impl;

import com.hotel.management.dao.AbstractDao;
import com.hotel.management.dao.BookingDao;
import com.hotel.management.entities.Booking;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PAUL
 */
@Repository("bookingDao")
public class BookingDaoImpl extends AbstractDao<Integer, Booking> implements BookingDao {
 
    public Booking findById(int id) {
        return getByKey(id);
    }
 
    public void save(Booking b) {
        persist(b);
    }
 
    public void deleteById(int id) {
        Query query = getSession().createSQLQuery("delete from Booking where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<Booking> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Booking>) criteria.list();
    }
 
    @SuppressWarnings("unchecked")
    public List<Booking> findByDate(LocalDate date) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dateBooking", date));
        return (List<Booking>) criteria.list();
    }
 
    public Booking findOneByNum(String num) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("numBooking", num));
        return (Booking) criteria.uniqueResult();
    }
}
