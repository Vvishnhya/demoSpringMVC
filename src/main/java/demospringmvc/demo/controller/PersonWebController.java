package demospringmvc.demo.controller;

import demospringmvc.demo.model.Person;
import demospringmvc.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonWebController {

    @Autowired
    private PersonService service;

    @GetMapping
    public String getPerson(Model model){
        model.addAttribute("person", service.getSimplePerson());
        return "personView";
    }

    @PostMapping
    public String setPerson (@RequestBody Person newPerson) {
        return "personView";
    }

}
