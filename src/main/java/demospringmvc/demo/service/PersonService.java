package demospringmvc.demo.service;

import demospringmvc.demo.model.Person;
import demospringmvc.demo.reposytory.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public List<Person> getAll() {
        return repository.getAll();
    }

    public Person getSimplePerson() {
        return new Person("Jan", "Kowalski", 32, 'M');
    }

    public Person modifyPerson(Person person) {
        person.setFirstName(person.getFirstName() + "*");
        return person;
    }

    public Person getEmptyPerson() {
        return new Person("*", "*", 18, '*');
    }

    public Long addPerson(Person newPerson) {
        return repository.add(newPerson);
    }

    public Person getPerson(Long id) {
        return repository.getById(id);
    }

}
