package pl.coderslab.entity;

import javax.persistence.*;

@Entity
@Table(name = "status")
public class Status {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean activity;  //aktywność	-	statusów	które	nie	są	aktywne
//nie	możemy	przypisać	do	zadania

    private int sorted;  //kolejność	sortowania	-	pole	numeryczne	po
//którym	posortujemy	statusy,	możliwe	do
//określenia	przez	administratora.  IDV do dat??

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

    public boolean isActivity() {
        return activity;
    }

    public void setActivity(boolean activity) {
        this.activity = activity;
    }

    public int getSorted() {
        return sorted;
    }

    public void setSorted(int sorted) {
        this.sorted = sorted;
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