/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.dao.impl;

import com.hotel.management.dao.AbstractDao;
import com.hotel.management.dao.RoleDao;
import com.hotel.management.entities.Role;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PAUL
 */
@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao {
 
    public Role findById(int id) {
        return getByKey(id);
    }
 
    public void save(Role r) {
        persist(r);
    }
 
    public void deleteById(int id) {
        Query query = getSession().createSQLQuery("delete from Role where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<Role> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Role>) criteria.list();
    }
 
    public Role findOneByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nameRole", name));
        return (Role) criteria.uniqueResult();
    }
}
