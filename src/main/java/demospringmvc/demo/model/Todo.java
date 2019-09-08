package demospringmvc.demo.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Todo {
    @Id
    Long id;
    String task;

    public Todo() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Todo(Long id, String task) {
        this.id = id;
        this.task = task;
    }
}
