package com.experian.controllers;

import com.experian.entities.Person;
import com.experian.services.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by lee.flatt on 1/13/2017.
 */
@Controller
public class SpringBarryController {

    @Autowired
    PersonRepository people;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("peopleList", people.findAll());
        return "index";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String add(String name, int age) {
        Person p = new Person(name, age);
        people.save(p);
        return "redirect:/";
    }
}
