package be.tetjes.angulartest.service;

import be.tetjes.angulartest.domain.commands.income.CreateIncomeCommand;
import be.tetjes.angulartest.domain.entities.Income;
import be.tetjes.angulartest.domain.repositories.IncomeRepository;
import be.tetjes.angulartest.iface.IIncome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository repository;

    @Transactional
    public Collection<IIncome> getIncomes() {
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

    @Transactional
    public Collection<IIncome> getIncomesPerTeam(Long teamId) {
        Collection<IIncome> incomes = getIncomes()
                .stream()
                .filter(income -> teamId == income.getTeamId())
                .collect(Collectors.toList());
        return incomes;
    }
}
