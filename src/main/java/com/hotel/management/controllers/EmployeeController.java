/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.management.controllers;

import com.hotel.management.entities.Employee;
import com.hotel.management.entities.Role;
import com.hotel.management.services.EmployeeService;
import com.hotel.management.services.RoleService;
import java.util.List;
import java.util.Locale;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author PAUL
 */
@Controller
@RequestMapping("/")
public class EmployeeController {

    public static final String FORM_VIEW = "/employee-edit";
    public static final String LIST_VIEW = "/employee-list";
    public static final String CURRENT = "select";
    public static final String SELECT = "selected";
    @Autowired
    EmployeeService empService;
    RoleService roleService;

    @Autowired
    MessageSource messageSource;

    @ModelAttribute("fonction")
    public List<Role> listRole() {
        return this.roleService.findAll();
    }

    //ajout d'un nouvel employe
    @RequestMapping(value = {"/employee/edit.htm"}, method = RequestMethod.GET)
    public String newEmployee(ModelMap model) {
        Employee emp = new Employee();
        model.addAttribute("employee", emp);
        model.addAttribute("edit", false);
        return FORM_VIEW;
    }

    /*cette methode est appelee lors de la validation du formulaire 
     pour enregistrer l'employe dans la base
     */
    @RequestMapping(value = {"/employee/edit.htm"}, method = RequestMethod.POST)
    public String save(@Valid Employee emp, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return FORM_VIEW;
        }

        /*
         * gestion de l'unicite du nom du professeur
         * 
         */
        if (!empService.isEmployeeUnique(emp.getId(), emp.getName())) {
            FieldError nameError = new FieldError("employee", "name", messageSource.getMessage("non.unique.name", new String[]{emp.getName()}, Locale.getDefault()));
            result.addError(nameError);
            return FORM_VIEW;
        }

        empService.save(emp);

        model.addAttribute("success", "Employee " + emp.getName() + " enregistre avec succes!");
//        return "success";
        return "redirect:" + LIST_VIEW;
    }

    //recuperation de l'enregistrement pour la modification
    @RequestMapping(value = {"/employee/edit.htm"}, params = "id", method = RequestMethod.GET)
    public String editEmployee(@PathVariable int id, ModelMap model) {
        Employee emp = empService.findById(id);
        model.addAttribute("employee", emp);
        model.addAttribute("edit", true);
        return FORM_VIEW;
    }

    //cette methode est appelee lors de la validation de la modification
    @RequestMapping(value = {"/employee/edit.htm"}, params = "id", method = RequestMethod.POST)
    public String update(@Valid Employee emp, BindingResult result,
            ModelMap model, @PathVariable int id) {

        if (result.hasErrors()) {
            return FORM_VIEW;
        }

        if (!empService.isEmployeeUnique(emp.getId(), emp.getName())) {
            FieldError nameError = new FieldError("employee", "name", messageSource.getMessage("non.unique.name", new String[]{emp.getName()}, Locale.getDefault()));
            result.addError(nameError);
            return FORM_VIEW;
        }

        empService.update(emp);

        model.addAttribute("success", "Employee " + emp.getName() + " mis a jour avec succes");
//        return "success";
        return "redirect:" + LIST_VIEW;
    }

    //liste de tous les employes
    @RequestMapping(value = {"/employee/list.htm"}, method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {
        List<Employee> emp = empService.findAll();
        model.addAttribute("employees", emp);
        return LIST_VIEW;
    }

    //cette methode est appelee lors de l suppression
    @RequestMapping(value = {"/employee/delete.htm"}, params = "id", method = RequestMethod.GET)
    public String delete(@PathVariable int id, ModelMap model) {
        empService.deleteById(id);
        model.addAttribute("success", "Suppression effectuee avec succes!");
        return LIST_VIEW;
    }
}
