package be.tetjes.angulartest.api.dto;

import be.tetjes.angulartest.infrastructure.NestedBuilder;

public class AvailableGoldPerRealmDto {

    public String realm;
    public String player;
    public int gold;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends NestedBuilder<AvailableGoldPerRealmDto> {

        @Override
        protected AvailableGoldPerRealmDto createInstance() {
            return new AvailableGoldPerRealmDto();
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
