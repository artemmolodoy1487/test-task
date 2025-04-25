package by.starovoytov.app.models;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;

import jakarta.validation.constraints.NotNull;


import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
@Table(name = "EMAIL_DATA")
public class EmailData {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false, unique = true)
    @NotNull(message = "email must have user")
    private User user;

    @Column(name = "EMAIL", nullable = false, unique = true)
    @NotNull(message = "email cant be null")
    private String email;


}
