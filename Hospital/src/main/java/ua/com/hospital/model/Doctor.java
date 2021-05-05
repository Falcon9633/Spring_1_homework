package ua.com.hospital.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Doctor {
    @Id
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    @ToString.Exclude
    private Account account;
    @ManyToOne(fetch = FetchType.LAZY)
    private Specialization specialization;
}
