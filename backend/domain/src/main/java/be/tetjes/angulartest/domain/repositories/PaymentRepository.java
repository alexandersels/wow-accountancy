package be.tetjes.angulartest.domain.repositories;

import be.tetjes.angulartest.domain.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
