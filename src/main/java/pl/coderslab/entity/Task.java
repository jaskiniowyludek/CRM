package pl.coderslab.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime created;

    private String subject;
    @ManyToOne
    private Project project;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private Status status;

    @ManyToOne
    private Priority priority;

    @ManyToOne
    private User projectUser; //aktualnie	przydzielonego	użytkownika	-	połączenie	z	encją
    // użytkowników	-	wybieramy	tylko
//użytkowników	przydzielonych	do	projektu,	którego	dotyczy	zadanie.

    public Task() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getProjectUser() {
        return projectUser;
    }

    public void setProjectUser(User projectUser) {
        this.projectUser = projectUser;
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