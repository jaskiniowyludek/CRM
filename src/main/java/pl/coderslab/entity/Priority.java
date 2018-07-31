package pl.coderslab.entity;

import javax.persistence.*;

@Entity
@Table(name = "priority")
public class Priority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean activity; //aktywność	-	priorytetów	które	nie	są
//aktywne	nie	możemy	przypisać	do	zadania

    public Priority(){

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

    public boolean isActivity() {
        return activity;
    }

    public void setActivity(boolean activity) {
        this.activity = activity;
    }
}
//Priorytet ma zawierać nastepujące dane:
//nazwa
//aktywność	-	priorytetów	które	nie	są
//aktywne	nie	możemy	przypisać	do	zadania