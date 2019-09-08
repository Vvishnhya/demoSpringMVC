package demospringmvc.demo.repository;

import demospringmvc.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PersonRepository {

    private Map<Long, Person> personList = PersonFactory.create();

    public List<Person> getAll() {
        List<Person> list= new ArrayList<>(personList.values());

        return list;
    }

    public Person getByName(String name) {
        return new Person();
    }

    public Person getByLastname(String name) {
        return new Person();
    }

    public Person getById(Long id) {
        return personList.get(id);
    }

    public Long add(Person person) {
        Long newKey = 1L + Collections.max(personList.keySet());
        personList.put(newKey, person);
        return newKey;
    }

    public boolean delete(Person person) {
        Long key = -1L;
        for (Map.Entry<Long, Person> e : personList.entrySet()) {
            if (e.getValue().equals(person)) {
                key = e.getKey();
            }
        }
        return (personList.remove(key) != null);
    }

    public boolean deleteById(Long id) {
        return (personList.remove(id) != null);
    }

    public boolean exist(Person person) {
        return personList.containsValue(person);
    }

}

class PersonFactory {

    static Map<Long, Person> create() {
        Map<Long, Person> persons = new HashMap<>();
        persons.put(1L, new Person("Tomasz", "Janiak", 32, 'M'));
        persons.put(2L, new Person("Eliza", "Orzeszkowa", 22, 'F'));
        persons.put(3L, new Person("Rober", "Bryza", 42, 'M'));
        return persons;
    }

}
