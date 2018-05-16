package be.tetjes.angulartest.service;

import be.tetjes.angulartest.domain.commands.payment.CreatePaymentCommand;
import be.tetjes.angulartest.domain.commands.player.CreatePlayerCommand;
import be.tetjes.angulartest.domain.entities.Payment;
import be.tetjes.angulartest.domain.repositories.IncomeRepository;
import be.tetjes.angulartest.domain.repositories.PaymentRepository;
import be.tetjes.angulartest.iface.IPayment;
import be.tetjes.angulartest.iface.IPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    @Transactional
    public Collection<IPayment> getPayments() {
        return repository.findAll().stream()
                .map(Payment.class::cast)
                .collect(toList());
    }

    @Transactional
    public IPayment getById(Long id) {
        return repository.findOne(id);
    }

    @Transactional
    public IPayment createPayment(CreatePaymentCommand command) {
        return repository.save(Payment.createPayment(command));
    }

    @Transactional
    public Collection<IPayment> getPaymentsPerPlayer(Long playerId) {
        return getPayments()
                .stream()
                .filter(p -> p.getPlayerId() == playerId)
                .collect(Collectors.toList());
    }

}
