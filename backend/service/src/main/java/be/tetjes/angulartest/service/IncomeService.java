package be.tetjes.angulartest.service;

import be.tetjes.angulartest.domain.commands.income.CreateIncomeCommand;
import be.tetjes.angulartest.domain.commands.player.CreatePlayerCommand;
import be.tetjes.angulartest.domain.entities.Income;
import be.tetjes.angulartest.domain.entities.Player;
import be.tetjes.angulartest.domain.repositories.IncomeRepository;
import be.tetjes.angulartest.domain.repositories.PlayerRepository;
import be.tetjes.angulartest.iface.IIncome;
import be.tetjes.angulartest.iface.IPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository repository;

    @Transactional
    public List<IIncome> findAll() {
        return repository.findAll().stream()
                .map(Income.class::cast)
                .collect(toList());
    }

    @Transactional
    public IIncome getIncome(Long id) {
        return repository.findOne(id);
    }

    @Transactional
    public IIncome createIncome(CreateIncomeCommand command) {
        return repository.save(Income.createIncome(command));
    }

}
