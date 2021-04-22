package ua.com.hospital.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ua.com.hospital.model.enums.Role;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String login;
    @ToString.Exclude
    private String password;
    private String email;
    private boolean locked;
    private Role role;
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private AccountDetails accountDetails;
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Doctor doctor;
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Patient patient;
}
