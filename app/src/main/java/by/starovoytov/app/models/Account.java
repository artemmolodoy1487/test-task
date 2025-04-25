package by.starovoytov.app.models;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GeneratedValue;

import jakarta.validation.constraints.NotNull;


import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "USER_ID", nullable = false, unique = true)
    @NotNull(message = "account must have user")
    private User user;


    @Column(nullable = false, precision = 10, scale = 2)
    @NotNull(message = "balance cant be NULL")
    private BigDecimal balance;


    @Column(name = "INITIAL_DEPOSIT", nullable = false, precision = 10, scale = 2)
    @NotNull(message = "initialDeposit cant be NULL")
    private BigDecimal initialDeposit;
}
