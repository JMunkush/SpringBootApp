package com.munkush.MySpringBootApp.controller.controller;

import com.munkush.MySpringBootApp.controller.service.PersonService;
import com.munkush.MySpringBootApp.controller.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/index")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping
    public String indexPage(Model model){
        model.addAttribute("persons",personService.getAllPersons());
        return "/index";
    }

    @GetMapping("/get/{id}")
    public String findOne(@PathVariable("id") int id,Model model){
        model.addAttribute("person",personService.getPerson(id));
        return "/show";
    }

    @GetMapping("/new")
    public String newPage(@ModelAttribute("newPerson") Person person){
        return "/new";
    }

    @PostMapping
    public String newPerson(@ModelAttribute("newPerson") @Valid Person person, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/new";
        }
        personService.save(person);
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id,Model model){
        model.addAttribute("newPerson",personService.getPerson(id));
        return "/edit";
    }

    @GetMapping("/delete/{id}")
    public String editPerson(@PathVariable("id") int id){
        personService.delete(id);
        return "redirect:/index";
    }


}
