package be.tetjes.angulartest.api.dto;

import be.tetjes.angulartest.infrastructure.NestedBuilder;

public class GoldPerRealmDto {

    public String realm;
    public String player;
    public int gold;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends NestedBuilder<GoldPerRealmDto> {

        @Override
        protected GoldPerRealmDto createInstance() {
            return new GoldPerRealmDto();
        }

        public Builder withRealm(String realm) {
            instance().realm = realm;
            return this;
        }

        public Builder withPlayer(String player) {
            instance().player = player;
            return this;
        }

        public Builder withGold(int gold) {
            instance().gold = gold;
            return this;
        }

    }

}
