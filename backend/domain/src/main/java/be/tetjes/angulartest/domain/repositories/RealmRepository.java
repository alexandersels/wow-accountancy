package be.tetjes.angulartest.domain.repositories;

import be.tetjes.angulartest.domain.entities.Realm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealmRepository extends JpaRepository<Realm, Long> {
}
