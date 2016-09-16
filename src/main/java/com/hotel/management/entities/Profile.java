/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author PAUL
 */
@Entity
@Table(name = "PROFILE")
public class Profile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column
    private int numProfil;
    
    @Column
    private String rule;
    
    @Column
    private boolean isGranted;

    @ManyToOne
    private Employee employee;
    //constructors
    public Profile() {
    }

    public Profile(int numProfil, String rule, boolean isGranted) {
        this.numProfil = numProfil;
        this.rule = rule;
        this.isGranted = isGranted;
    }

    //getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumProfil() {
        return numProfil;
    }

    public void setNumProfil(int numProfil) {
        this.numProfil = numProfil;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public boolean isIsGranted() {
        return isGranted;
    }

    public void setIsGranted(boolean isGranted) {
        this.isGranted = isGranted;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hotel.entities.Profile[ id=" + id + " ]";
    }
    
}
