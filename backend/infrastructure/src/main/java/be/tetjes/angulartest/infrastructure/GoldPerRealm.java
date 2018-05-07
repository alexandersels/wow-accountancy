package be.tetjes.angulartest.infrastructure;

public class GoldPerRealm {


    private int gold;
    private Long realmId;
    private Long playerId;

    public GoldPerRealm(Long realmId, Long playerId) {
        this.realmId = realmId;
        this.playerId = playerId;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public Long getRealmId() {
        return realmId;
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



}
