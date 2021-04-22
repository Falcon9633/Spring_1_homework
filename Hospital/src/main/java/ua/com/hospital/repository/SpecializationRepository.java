package ua.com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.hospital.model.Specialization;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
}
