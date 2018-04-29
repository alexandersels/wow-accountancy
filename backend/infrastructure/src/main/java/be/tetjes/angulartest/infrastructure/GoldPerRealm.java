package be.tetjes.angulartest.infrastructure;

public class GoldPerRealm {


    private int gold;
    private String realm;
    private String player;

    public GoldPerRealm(String realm, String player) {
        this.realm = realm;
        this.player = player;
    }

    public String getPlayer() {
        return player;
    }

    public int getGold() {
        return gold;
    }

    public void increaseGold(int gold) {
        this.gold += gold;
    }

    public void decreaseGold(int gold) {
        this.gold -= gold;
    }
    public String getRealm() {
        return realm;
    }


}
