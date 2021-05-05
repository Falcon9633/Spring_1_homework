package ua.com.hospital.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class AccountDetails {
    @Id
    private Long id;
    private String name;
    private String surname;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    @ToString.Exclude
    private Account account;
}
