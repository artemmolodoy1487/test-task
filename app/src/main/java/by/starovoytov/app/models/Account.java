package by.starovoytov.app.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @OneToOne
    @JoinColumn(name = "USER_ID", nullable = false, unique = true)
    @NotNull(message = "Account must have a user")
    private User user;

    @Column(name = "BALANCE", nullable = false, precision = 10, scale = 2)
    @NotNull(message = "Balance cannot be null")
    private BigDecimal balance;
}