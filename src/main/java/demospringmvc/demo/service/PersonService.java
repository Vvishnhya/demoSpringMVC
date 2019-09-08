package demospringmvc.demo.service;

import demospringmvc.demo.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {


        public Person getSimplePerson(){
            return  new Person("Jan", "Kowalski", 32, 'M');
        }
        public Person modifyPerson (Person person){
            person.setFirstName(person.getFirstName() + "*");
            return person;
        }
    }

