package by.starovoytov.app.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "PHONE_DATA")
public class PhoneData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    @NotNull(message = "Phone data must have a user")
    private User user;

    @Column(name = "PHONE", nullable = false, length = 13, unique = true)
    @NotNull(message = "Phone number cannot be null")
    private String phone;
}