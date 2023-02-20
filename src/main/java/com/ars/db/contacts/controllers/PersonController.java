package com.ars.db.contacts.controllers;

import com.ars.db.contacts.domain.Person;
import com.ars.db.contacts.service.PersonService;
import com.ars.db.contacts.service.PersonServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PersonController {
    @GetMapping("/persons")
    @ResponseBody
    public List<Person> person() {
        PersonService service = new PersonServiceImpl();

        return service.getAll();
    }
}
