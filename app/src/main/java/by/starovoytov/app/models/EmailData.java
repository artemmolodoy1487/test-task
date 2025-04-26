package by.starovoytov.app.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "EMAIL_DATA")
public class EmailData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    @NotNull(message = "Email must have a user")
    private User user;

    @Column(name = "EMAIL", nullable = false, length = 200, unique = true)
    @NotNull(message = "Email cannot be null")
    private String email;
}