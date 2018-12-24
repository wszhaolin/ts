package com.baizhi.controller;

import com.baizhi.entity.Person;
import com.baizhi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    @RequestMapping("/findPerson")
    public String findAll(Model model, Person person, HttpServletRequest request){
        personService.showUsersByPage(request,model,person);
        return "personlist";
    }
    private void logo(HttpServletRequest request, Model model, Person person) {
        personService.showUsersByPage(request, model,person);
    }
    @RequestMapping(value = "/findAll")
    public String findUsersByUserName(HttpServletRequest request, Model model,Person person) {
        logo(request, model, person);
        return "personlist";
    }

    @RequestMapping("/insert")
    public String regis(Person person){
        personService.insertP(person);
        return "redirect:/person/findAll";
    }
    @RequestMapping("/update")
    public String update(Person person){
    personService.updateP(person);
        return "redirect:/person/findAll";
    }
    @RequestMapping("/delete")
    public String delete(String id){
        personService.deleteP(id);
        return "redirect:/person/findAll";
    }
    @RequestMapping("/findOne")
    public String findOne(Model model,String id){
        Person person = personService.findOne(id);
        model.addAttribute("person",person);
        return "forward:/updatePerson.jsp";
    }
}
