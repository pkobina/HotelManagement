/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.management.entities;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author PAUL
 */
@Entity
@Table(name = "ROOMTYPE")
public class RoomType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotNull
    @Column
    private String nameType;
    
    @NotNull
    @Column
    private String descTye;
    
    @NotEmpty
    @Column
    private double priceType;
    
    @Column
    private boolean del;

    @OneToMany(mappedBy = "roomType")
    private List<Room> rooms = new LinkedList<>();
    
    //constructors
    public RoomType() {
    }

    public RoomType(String nameType, String descTye, double priceType) {
        this.nameType = nameType;
        this.descTye = descTye;
        this.priceType = priceType;
    }
    
    //getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public String getDescTye() {
        return descTye;
    }

    public void setDescTye(String descTye) {
        this.descTye = descTye;
    }

    public double getPriceType() {
        return priceType;
    }

    public void setPriceType(double priceType) {
        this.priceType = priceType;
    }

    public boolean isDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
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
        if (!(object instanceof RoomType)) {
            return false;
        }
        RoomType other = (RoomType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hotel.entities.RoomType[ id=" + id + " ]";
    }
    
}
