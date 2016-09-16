/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.dao.impl;

import com.hotel.management.dao.AbstractDao;
import com.hotel.management.dao.ClientDao;
import com.hotel.management.entities.Client;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PAUL
 */
@Repository("clientDao")
public class ClientDaoImpl extends AbstractDao<Integer, Client> implements ClientDao {
 
    public Client findById(int id) {
        return getByKey(id);
    }
 
    public void save(Client c) {
        persist(c);
    }
 
    public void deleteById(int id) {
        Query query = getSession().createSQLQuery("delete from Client where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<Client> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Client>) criteria.list();
    }
 
    public Client findOneByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (Client) criteria.uniqueResult();
    }
 
    public Client findOneByValidCod(String cod) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("validCod", cod));
        return (Client) criteria.uniqueResult();
    }
}
