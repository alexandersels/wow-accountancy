package be.tetjes.angulartest.domain.repositories;

import be.tetjes.angulartest.domain.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
