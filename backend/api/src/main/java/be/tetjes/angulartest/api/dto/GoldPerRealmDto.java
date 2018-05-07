package be.tetjes.angulartest.api.dto;

import be.tetjes.angulartest.infrastructure.NestedBuilder;

public class GoldPerRealmDto {

    public RealmDto realm;
    public PlayerDto player;
    public int gold;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends NestedBuilder<GoldPerRealmDto> {

        @Override
        protected GoldPerRealmDto createInstance() {
            return new GoldPerRealmDto();
        }

        public Builder withRealm(RealmDto realm) {
            instance().realm = realm;
            return this;
        }

        public Builder withPlayer(PlayerDto player) {
            instance().player = player;
            return this;
        }

        public Builder withGold(int gold) {
            instance().gold = gold;
            return this;
        }

    }

}
