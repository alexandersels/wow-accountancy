package be.tetjes.angulartest.infrastructure;

public class Split {

    private String playerName;
    private double debt;
    private int amountOfRuns;
    private int totalGoldEarned;

    public Split(String playerName, double debt, int amountOfRuns, int totalGoldEarned) {
        this.playerName = playerName;
        this.debt = debt;
        this.amountOfRuns = amountOfRuns;
        this.totalGoldEarned = totalGoldEarned;
    }

    public String getPlayerName() {
        return playerName;
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
