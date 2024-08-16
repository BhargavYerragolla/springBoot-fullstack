package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("person", new Person());
        return "personForm";
    }

    @PostMapping("/save")
    public String savePerson(Person person, Model model) {
        personService.savePerson(person);
        model.addAttribute("persons", personService.getAllPersons());
        return "result";
    }
    
  
    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") Long id, Model model) {
        personService.deletePersonById(id);
        model.addAttribute("persons", personService.getAllPersons());
        return "result";
    }


    
}
