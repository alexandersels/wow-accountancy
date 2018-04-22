package be.tetjes.angulartest.domain.repositories;

import be.tetjes.angulartest.domain.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
