package by.starovoytov.app.models;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "USER")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false , length = 500)
    private String name;


    @Column(nullable = false, name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    @Column(nullable = false, length = 500)
    private String password;



}
