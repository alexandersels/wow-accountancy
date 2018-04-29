package be.tetjes.angulartest.service;

import be.tetjes.angulartest.iface.IIncome;
import be.tetjes.angulartest.iface.IPayment;
import be.tetjes.angulartest.iface.IPlayer;
import be.tetjes.angulartest.iface.ITeam;
import be.tetjes.angulartest.infrastructure.Split;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class SplitService {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private IncomeService incomeService;

    @Autowired
    private PaymentService paymentService;

    @Transactional
    public Collection<Split> getSplits() {
        List<Split> splits = new ArrayList<>();

        Collection<IPlayer> players = playerService.getPlayers();
        for (IPlayer player : players) {
            splits.add(getSplit(player.getName()));
        }

        return splits;
    }

    @Transactional
    public Split getSplit(String playerName) {
        Collection<ITeam> teams = teamService.getTeamsForPlayer(playerName);

        int totalGold = 0;
        int split = 0;
        int amountOfRuns = 0;

        for (ITeam team : teams) {
            Collection<IIncome> incomes = incomeService.getIncomesPerTeam(team.getName());
            for (IIncome income : incomes) {
                totalGold += income.getPrice();
                split += income.getPrice();
                amountOfRuns++;
            }

            Collection<IPayment> payments = paymentService.getPaymentsPerPlayer(playerName);
            for(IPayment payment: payments) {
                split -= payment.getPrice();
            }
        }

        double debt = split / 4.0;
        return new Split(playerName, debt, amountOfRuns, totalGold);
    }
}
