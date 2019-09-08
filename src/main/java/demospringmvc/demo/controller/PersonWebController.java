package demospringmvc.demo.controller;

import demospringmvc.demo.model.Person;
import demospringmvc.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/person")
public class PersonWebController {

    @Autowired
    private PersonService service;

    @GetMapping
    public String getPerson(Model model) {
        model.addAttribute("person", service.getSimplePerson());
        return "personView";
    }

    @PostMapping
    public String setPerson(Person newPerson, Model model) {
        Long id = service.addPerson(newPerson);
        model.addAttribute("person", service.getPerson(id));
        return "personView";
    }

    @GetMapping("/add")
    public String gotToPersonForm(Model model) {
        model.addAttribute("person", service.getEmptyPerson());
        return "personForm";
    }

    @GetMapping("/list")
    public ModelAndView showAllPersons(ModelAndView mav) {
        mav.setViewName("personList");
        mav.addObject("personList", service.getAll());
        return mav;
    }

}