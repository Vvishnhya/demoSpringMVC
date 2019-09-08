package demospringmvc.demo.controller;


import demospringmvc.demo.model.Person;
import demospringmvc.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping
    public String getPerson(Model model){
        model.addAttribute("person", service.getSimplePerson());
        return "personView";

    }

    @PostMapping
    public String setPerson (@RequestBody Person newPerson){

        return "personView";
    }

}
