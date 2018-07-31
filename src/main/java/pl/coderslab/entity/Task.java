package pl.coderslab.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime localDateTime;

    private String subject;
    @ManyToMany
    private List<Project> projects;  //projekt	-	połączenie	z	encją	projektów

    private String description;

    @OneToOne
    private Status status;  //status	-	połączenie	z	encją	statusów
    @OneToOne
    private Priority priority;  //priorytet	-	połączenie	z	encją	priorytetów
    @ManyToMany
    private List<User> users; //aktualnie	przydzielonego	użytkownika	-	połączenie	z	encją	użytkowników	-	wybieramy	tylko
//użytkowników	przydzielonych	do	projektu,	którego	dotyczy	zadanie.

    public Task() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}


//Zadanie
//ma	zawierać	następujące	dane:
//data	utworzenia
//temat
//projekt	-	połączenie	z	encją	projektów
//opis
//status	-	połączenie	z	encją	statusów
//priorytet	-	połączenie	z	encją	priorytetów
//aktualnie	przydzielonego	użytkownika	-	połączenie	z	encją	użytkowników	-	wybieramy	tylko
//użytkowników	przydzielonych	do	projektu,	którego	dotyczy	zadanie.