/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.dao.impl;

import com.hotel.management.dao.AbstractDao;
import com.hotel.management.dao.BillDao;
import com.hotel.management.entities.Bill;
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
@Repository("billDao")
public class BillDaoImpl extends AbstractDao<Integer, Bill> implements BillDao {
 
    public Bill findById(int id) {
        return getByKey(id);
    }
 
    public void save(Bill b) {
        persist(b);
    }
 
    public void deleteById(int id) {
        Query query = getSession().createSQLQuery("delete from Bill where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<Bill> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Bill>) criteria.list();
    }
 
    @SuppressWarnings("unchecked")
    public List<Bill> findByDate(LocalDate date) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dateBill", date));
        return (List<Bill>) criteria.list();
    }
 
    public Bill findOneByNum(String num) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("numBill", num));
        return (Bill) criteria.uniqueResult();
    }
}
