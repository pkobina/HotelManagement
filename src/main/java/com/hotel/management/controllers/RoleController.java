/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.management.controllers;

import com.hotel.management.entities.Role;
import com.hotel.management.services.RoleService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author PAUL
 */
@Controller
@RequestMapping("/")
public class RoleController {

    public static final String FORM_VIEW = "/role-edit";
    public static final String LIST_VIEW = "/role-list";
    public static final String CURRENT = "select";
    public static final String SELECT = "selected";
    @Autowired
    RoleService roleService;

    @Autowired
    MessageSource messageSource;

    //ajout d'un nouveau role/fonction
    @RequestMapping(value = {"/role/edit.htm"}, method = RequestMethod.GET)
    public String newType(ModelMap model) {
        Role r = new Role();
        model.addAttribute("role", r);
        model.addAttribute("edit", false);
        return FORM_VIEW;
    }

    /*cette methode est appelee lors de la validation du formulaire 
     pour enregistrer le role ou fonction dans la base
     */
    @RequestMapping(value = {"/role/edit.htm"}, method = RequestMethod.POST)
    public String save(@Valid Role r, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return FORM_VIEW;
        }

        /*
         * gestion de l'unicite du nom du professeur
         * 
         */
//        if (!roleService.is(emp.getId(), emp.getName())) {
//            FieldError nameError = new FieldError("employee", "name", messageSource.getMessage("non.unique.name", new String[]{emp.getName()}, Locale.getDefault()));
//            result.addError(nameError);
//            return FORM_VIEW;
//        }

        roleService.save(r);

        model.addAttribute("success", "Role " + r.getNameRole()+ " enregistre avec succes!");
//        return "success";
        return "redirect:" + LIST_VIEW;
    }

    //recuperation de l'enregistrement pour la modification
    @RequestMapping(value = {"/role/edit.htm"}, params = "id", method = RequestMethod.GET)
    public String edit(@PathVariable int id, ModelMap model) {
        Role r = roleService.findById(id);
        model.addAttribute("role", r);
        model.addAttribute("edit", true);
        return FORM_VIEW;
    }

    //cette methode est appelee lors de la validation de la modification
    @RequestMapping(value = {"/role/edit.htm"}, params = "id", method = RequestMethod.POST)
    public String update(@Valid Role rt, BindingResult result,
            ModelMap model, @PathVariable int id) {

        if (result.hasErrors()) {
            return FORM_VIEW;
        }

//        if (!rtService.isEmployeeUnique(emp.getId(), emp.getName())) {
//            FieldError nameError = new FieldError("employee", "name", messageSource.getMessage("non.unique.name", new String[]{emp.getName()}, Locale.getDefault()));
//            result.addError(nameError);
//            return FORM_VIEW;
//        }

        roleService.update(rt);

        model.addAttribute("success", "Role " + rt.getNameRole()+ " mis a jour avec succes");
//        return "success";
        return "redirect:" + LIST_VIEW;
    }

    //liste de tous les types de chambre
    @RequestMapping(value = {"/role/list.htm"}, method = RequestMethod.GET)
    public String list(ModelMap model) {
        List<Role> rt = roleService.findAll();
        model.addAttribute("roles", rt);
        return LIST_VIEW;
    }

    //cette methode est appelee lors de l suppression
    @RequestMapping(value = {"/role/delete.htm"}, params = "id", method = RequestMethod.GET)
    public String delete(@PathVariable int id, ModelMap model) {
        roleService.deleteById(id);
        model.addAttribute("success", "Suppression effectuee avec succes!");
        return LIST_VIEW;
    }
}
