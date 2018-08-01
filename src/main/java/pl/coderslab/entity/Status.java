package pl.coderslab.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "status")
public class Status {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean active;  //aktywność	-	statusów	które	nie	są	aktywne
//nie	możemy	przypisać	do	zadania

    private int sortOrder;  //kolejność	sortowania	-	pole	numeryczne	po
//którym	posortujemy	statusy,	możliwe	do
//określenia	przez	administratora.
    @OneToMany(mappedBy = "status")
    private List<Task> tasks;

    public Status() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}

//Status
//ma zawierać nastepujące dane
//nazwa
//aktywność	-	statusów	które	nie	są	aktywne
//nie	możemy	przypisać	do	zadania
//kolejność	sortowania	-	pole	numeryczne	po
//którym	posortujemy	statusy,	możliwe	do
//określenia	przez	administratora.  IDV do dat??