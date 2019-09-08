package demospringmvc.demo.service;

import demospringmvc.demo.model.Todo;
import demospringmvc.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository repository;

    public List<Todo> all() {
        List<Todo> list = new ArrayList<>();
        repository.findAll().forEach(list::add);

        //repository.findAll().forEach(e->list.add(e));

        return list;
    }
}
