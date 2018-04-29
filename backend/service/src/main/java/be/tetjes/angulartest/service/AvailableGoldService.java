package be.tetjes.angulartest.service;

import be.tetjes.angulartest.iface.IIncome;
import be.tetjes.angulartest.iface.IPayment;
import be.tetjes.angulartest.iface.IRealm;
import be.tetjes.angulartest.infrastructure.AvailableGold;
import be.tetjes.angulartest.infrastructure.GoldPerRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvailableGoldService {

    @Autowired
    private RealmService realmService;

    @Autowired
    private IncomeService incomeService;

    @Autowired
    private PaymentService paymentService;

    @Transactional
    public AvailableGold getAvailableGold() {

        Collection<IRealm> realms = realmService.getRealms();
        Collection<IIncome> incomes = incomeService.getIncomes();
        Collection<IPayment> payments = paymentService.getPayments();

        int totalGold = 0;
        int remainingGold = 0;
        HashMap<String, GoldPerRealm> dictionary = new HashMap<>();
        for (IRealm realm : realms) {

            String realmName = realm.getName();
            if(!dictionary.containsKey(realmName)) {
                dictionary.put(realmName, new GoldPerRealm(realmName, realm.getPlayer()));
            }
            GoldPerRealm gold = dictionary.get(realmName);

            for(IIncome income : getIncomesByRealm(realmName, incomes)) {
                gold.increaseGold(income.getPrice());
                totalGold += income.getPrice();
                remainingGold += income.getPrice();
            }

            for(IPayment payment: getPaymentsByRealm(realmName, payments)) {
                gold.decreaseGold(payment.getPrice());
                remainingGold -= payment.getPrice();
            }
        }

        return new AvailableGold(totalGold, remainingGold, new ArrayList(dictionary.values()));
    }


    private List<IIncome> getIncomesByRealm(String name, Collection<IIncome> incomes) {
        return incomes
                .stream()
                .filter(i -> i.getRealm().equals(name))
                .collect(Collectors.toList());
    }

    private List<IPayment> getPaymentsByRealm(String name, Collection<IPayment> payments) {
        return payments
                .stream()
                .filter(i -> i.getRealm().equals(name))
                .collect(Collectors.toList());
    }
}
