package pl.coderslab.entity;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.xml.soap.Text;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime created; //data	utworzenia	-	nadawa	automatycznie
    @Column(columnDefinition = "TEXT")
    private String description;
    @URL
    private String url; //strona	www	-	walidacja	poprawności
    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> users; //użytkownicy	-	może	być	wiele,	połączenie	z	encją	użytkowników
    @OneToMany(mappedBy = "project")
    private List<Task> tasks;

    private String identifier;  //identyfikator-	pole	nadawane	automatycznie	tworzone	przez
    // usunięcie	wszystkich	znaków
//diakrytycznych,	np.	(ółą)	z	pola	nazwa	oraz	zastąpienie	wszystkich	białych	znaków	znakiem
//myślnika.

    private boolean active; //aktywność	pole	boolean	-	dla	projektów	nie	aktywnych	nie	wyświetlamy
    // informacji	na	liście
//aktywności.

    public Project(){

    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

//Projekt
//ma	zawierać	następujące	dane:
//data	utworzenia	-	nadawa	automatycznie
//nazwa
//opis
//strona	www	-	walidacja	poprawności
//identyfikator-	pole	nadawane	automatycznie	tworzone	przez	usunięcie	wszystkich	znaków
//diakrytycznych,	np.	(ółą)	z	pola	nazwa	oraz	zastąpienie	wszystkich	białych	znaków	znakiem
//myślnika.
//użytkownicy	-	może	być	wiele,	połączenie	z	encją	użytkowników
//aktywność	pole	boolean	-	dla	projektów	nie	aktywnych	nie	wyświetlamy	informacji	na	liście
//aktywności.