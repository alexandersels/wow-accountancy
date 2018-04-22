package be.tetjes.angulartest.domain.repositories;

import be.tetjes.angulartest.domain.entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
}
