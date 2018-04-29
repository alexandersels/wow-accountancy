package be.tetjes.angulartest.service;

import be.tetjes.angulartest.iface.IIncome;
import be.tetjes.angulartest.iface.IRealm;
import be.tetjes.angulartest.infrastructure.AvailableGold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AvailableGoldService {

    @Autowired
    private RealmService realmService;

    @Autowired
    private IncomeService incomeService;

    @Transactional
    public AvailableGold getAvailableGold() {

        List<IRealm> realms = realmService.getRealms();
        List<IIncome> incomes = incomeService.getIncomes();

        // Calculate


        return new AvailableGold();
    }
}
