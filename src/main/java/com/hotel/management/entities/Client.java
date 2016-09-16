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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author PAUL
 */
@Entity
@Table(name = "CLIENT")
public class Client extends Person implements Serializable {
    
    @NotNull
    @Column
    private String identityDoc;
    
    @NotNull
    @Column
    private String numDoc;
    
    @Column
    private String validCod;

    @OneToMany(mappedBy = "client")
    private List<Booking> bookings = new LinkedList<>();
    
    //constructors
    public Client() {
    }

    public Client(String identityDoc, String numDoc, String validCod, String name, String phone, String address, String email, String sexe) {
        super(name, phone, address, email, sexe);
        this.identityDoc = identityDoc;
        this.numDoc = numDoc;
        this.validCod = validCod;
    }

    //getters and setters
    public String getIdentityDoc() {
        return identityDoc;
    }

    public void setIdentityDoc(String identityDoc) {
        this.identityDoc = identityDoc;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getValidCod() {
        return validCod;
    }

    public void setValidCod(String validCod) {
        this.validCod = validCod;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "com.hotel.entities.Client[ id=" + super.getId() + " ]";
    }
    
}
