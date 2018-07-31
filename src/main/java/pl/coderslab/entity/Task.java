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

    private String project;

    private String description;

    private String status;

    private String priority;

    private List<User> users;

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