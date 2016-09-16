/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.dao.impl;

import com.hotel.management.dao.AbstractDao;
import com.hotel.management.dao.ProfileDao;
import com.hotel.management.entities.Employee;
import com.hotel.management.entities.Profile;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PAUL
 */
@Repository("profileDao")
public class ProfileDaoImpl extends AbstractDao<Integer, Profile> implements ProfileDao {
 
    public Profile findById(int id) {
        return getByKey(id);
    }
 
    public void save(Profile p) {
        persist(p);
    }
 
    public void deleteById(int id) {
        Query query = getSession().createSQLQuery("delete from Profile where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<Profile> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Profile>) criteria.list();
    }
 
    @SuppressWarnings("unchecked")
    public List<Profile> findAllByEmployee(Employee e) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("employee.id", e.getId()));
        return (List<Profile>) criteria.list();
    }
 
    public Profile findOneByRule(String rule) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("rule", rule));
        return (Profile) criteria.uniqueResult();
    }
}
