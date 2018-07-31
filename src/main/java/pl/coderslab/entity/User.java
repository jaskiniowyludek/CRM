package pl.coderslab.entity;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String name;

    private String surname;

    private String password;
}

//Użytkownik
//ma	zawierać	następujące	dane:
//login	-	pole	unikalne	w	systemie
//imię
//nazwisko
//hasło	-	ma	być	hashowane	przed	zapisem	za	pomocą	dowolnego	algorytmu
//Status
//ma zawierać nastepujące dane
//nazwa
//aktywność	-	statusów	które	nie	są	aktywne
//nie	możemy	przypisać	do	zadania
//kolejność	sortowania	-	pole	numeryczne	po
//którym	posortujemy	statusy,	możliwe	do
//określenia	przez	administratora.