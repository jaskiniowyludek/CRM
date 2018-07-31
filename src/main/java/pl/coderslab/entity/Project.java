package pl.coderslab.entity;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDateTime localDateTime; //data	utworzenia	-	nadawa	automatycznie

    private String description;
    @URL
    private String url; //strona	www	-	walidacja	poprawności
    @ManyToMany
    private List<User> users; //użytkownicy	-	może	być	wiele,	połączenie	z	encją	użytkowników
    @ManyToMany
    private List<Task> tasks;

    private String identifier;  //identyfikator-	pole	nadawane	automatycznie	tworzone	przez	usunięcie	wszystkich	znaków
//diakrytycznych,	np.	(ółą)	z	pola	nazwa	oraz	zastąpienie	wszystkich	białych	znaków	znakiem
//myślnika.

    private boolean activity; //aktywność	pole	boolean	-	dla	projektów	nie	aktywnych	nie	wyświetlamy	informacji	na	liście
//aktywności.

    public Project(){

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

    public boolean isActivity() {
        return activity;
    }

    public void setActivity(boolean activity) {
        this.activity = activity;
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