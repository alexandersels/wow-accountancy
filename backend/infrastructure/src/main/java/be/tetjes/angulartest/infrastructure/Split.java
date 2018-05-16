package be.tetjes.angulartest.infrastructure;

import be.tetjes.angulartest.iface.IPlayer;

public class Split {

    private IPlayer player;
    private double debt;
    private int amountOfRuns;
    private int totalGoldEarned;

    public Split(IPlayer player, double debt, int amountOfRuns, int totalGoldEarned) {
        this.player = player;
        this.debt = debt;
        this.amountOfRuns = amountOfRuns;
        this.totalGoldEarned = totalGoldEarned;
    }

    public IPlayer getPlayer() {
        return player;
    }

    public double getDebt() {
        return debt;
    }

    public int getAmountOfRuns() {
        return amountOfRuns;
    }

    public int getTotalGoldEarned() {
        return totalGoldEarned;
    }





}
