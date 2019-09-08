package demospringmvc.demo.controller;


import demospringmvc.demo.model.Person;
import demospringmvc.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping(
            value = "/person",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getPerson() {
        return service.getAll();
    }

    @PostMapping("/person")
    public Person setPerson(@RequestBody Person newPerson) {
        return service.modifyPerson(newPerson);
    }
}