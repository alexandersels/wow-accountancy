package be.tetjes.angulartest.infrastructure;

import java.util.List;

public class AvailableGold {

    private int totalGold;
    private int remainingGold;
    private List<GoldPerRealm> goldPerRealm;

    public AvailableGold(int totalGold, int remainingGold, List<GoldPerRealm> goldPerRealm) {
        this.totalGold = totalGold;
        this.goldPerRealm = goldPerRealm;
        this.remainingGold = remainingGold;
    }

    public int getTotalGold() {

        return totalGold;
    }

    public int getRemainingGold() {
        return remainingGold;
    }

    public List<GoldPerRealm> getGoldPerRealm() {

        return goldPerRealm;
    }

}
