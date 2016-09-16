/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.management.controllers;

import com.hotel.management.entities.RoomType;
import com.hotel.management.services.RoomTypeService;
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
public class RoomTypeController {

    public static final String FORM_VIEW = "/roomtype-edit";
    public static final String LIST_VIEW = "/roomtype-list";
    public static final String CURRENT = "select";
    public static final String SELECT = "selected";
    @Autowired
    RoomTypeService rtService;

    @Autowired
    MessageSource messageSource;

    //ajout d'un nouveau type
    @RequestMapping(value = {"/roomtype/edit.htm"}, method = RequestMethod.GET)
    public String newType(ModelMap model) {
        RoomType rt = new RoomType();
        model.addAttribute("roomtype", rt);
        model.addAttribute("edit", false);
        return FORM_VIEW;
    }

    /*cette methode est appelee lors de la validation du formulaire 
     pour enregistrer le type de chambre dans la base
     */
    @RequestMapping(value = {"/roomtype/edit.htm"}, method = RequestMethod.POST)
    public String save(@Valid RoomType rt, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return FORM_VIEW;
        }

        /*
         * gestion de l'unicite du nom du professeur
         * 
         */
//        if (!rtService.is(emp.getId(), emp.getName())) {
//            FieldError nameError = new FieldError("employee", "name", messageSource.getMessage("non.unique.name", new String[]{emp.getName()}, Locale.getDefault()));
//            result.addError(nameError);
//            return FORM_VIEW;
//        }

        rtService.save(rt);

        model.addAttribute("success", "RoomType " + rt.getNameType()+ " enregistre avec succes!");
//        return "success";
        return "redirect:" + LIST_VIEW;
    }

    //recuperation de l'enregistrement pour la modification
    @RequestMapping(value = {"/roomtype/edit.htm"}, params = "id", method = RequestMethod.GET)
    public String edit(@PathVariable int id, ModelMap model) {
        RoomType rt = rtService.findById(id);
        model.addAttribute("roomtype", rt);
        model.addAttribute("edit", true);
        return FORM_VIEW;
    }

    //cette methode est appelee lors de la validation de la modification
    @RequestMapping(value = {"/roomtype/edit.htm"}, params = "id", method = RequestMethod.POST)
    public String update(@Valid RoomType rt, BindingResult result,
            ModelMap model, @PathVariable int id) {

        if (result.hasErrors()) {
            return FORM_VIEW;
        }

//        if (!rtService.isEmployeeUnique(emp.getId(), emp.getName())) {
//            FieldError nameError = new FieldError("employee", "name", messageSource.getMessage("non.unique.name", new String[]{emp.getName()}, Locale.getDefault()));
//            result.addError(nameError);
//            return FORM_VIEW;
//        }

        rtService.update(rt);

        model.addAttribute("success", "RoomType " + rt.getNameType()+ " mis a jour avec succes");
//        return "success";
        return "redirect:" + LIST_VIEW;
    }

    //liste de tous les types de chambre
    @RequestMapping(value = {"/roomtype/list.htm"}, method = RequestMethod.GET)
    public String list(ModelMap model) {
        List<RoomType> rt = rtService.findAll();
        model.addAttribute("roomtypes", rt);
        return LIST_VIEW;
    }

    //cette methode est appelee lors de l suppression
    @RequestMapping(value = {"/roomtype/delete.htm"}, params = "id", method = RequestMethod.GET)
    public String delete(@PathVariable int id, ModelMap model) {
        rtService.deleteById(id);
        model.addAttribute("success", "Suppression effectuee avec succes!");
        return LIST_VIEW;
    }
}
