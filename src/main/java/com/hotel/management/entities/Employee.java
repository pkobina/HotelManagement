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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author PAUL
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee extends Person implements Serializable {
    
    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    @Column
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate dob;
    
    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    @Column
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate hiredDate;
    
    @Column
    private String login;
    
    @Column
    private String password;

    @ManyToOne
    private Role role;
    
    @OneToMany(mappedBy = "employee")
    private List<Profile> profiles = new LinkedList<>();
    
    //constructors
    public Employee() {
    }

    public Employee(LocalDate dob, LocalDate hiredDate, String login, String password, String name, String phone, String address, String email, String sexe) {
        super(name, phone, address, email, sexe);
        this.dob = dob;
        this.hiredDate = hiredDate;
        this.login = login;
        this.password = password;
    }
    
    //getters and setters
    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(LocalDate hiredDate) {
        this.hiredDate = hiredDate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }
    
    @Override
    public String toString() {
        return "com.hotel.entities.Employee[ id=" + super.getId() + " ]";
    }
    
}
