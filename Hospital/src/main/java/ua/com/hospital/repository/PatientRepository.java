package ua.com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hospital.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
