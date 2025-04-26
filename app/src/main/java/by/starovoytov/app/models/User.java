package by.starovoytov.app.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "APP_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 500)
    @NotNull(message = "Name cannot be null")
    private String name;

    @Column(name = "DATE_OF_BIRTH", nullable = false)
    @NotNull(message = "Date of birth cannot be null")
    private LocalDate dateOfBirth;

    @Column(name = "PASSWORD", nullable = false, length = 500)
    @NotNull(message = "Password cannot be null")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @Size(min = 1, message = "User must have at least one phone number")
    private List<PhoneData> phoneDataList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @Size(min = 1, message = "User must have at least one email")
    private List<EmailData> emailDataList;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @NotNull(message = "User must have an account")
    private Account account;
}