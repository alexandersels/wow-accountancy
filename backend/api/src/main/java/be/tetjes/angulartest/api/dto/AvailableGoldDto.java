package be.tetjes.angulartest.api.dto;

import be.tetjes.angulartest.infrastructure.NestedBuilder;

import java.util.List;

public class AvailableGoldDto {

    public int totalGold;
    public int remainingGold;
    public List<GoldPerRealmDto> goldPerRealm;

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder extends NestedBuilder<AvailableGoldDto>
    {

        @Override
        protected AvailableGoldDto createInstance() {
            return new AvailableGoldDto();
        }

        public Builder withTotalGold(int totalGold) {
            instance().totalGold = totalGold;
            return this;
        }

        public Builder withRemainingGold(int remainingGold) {
            instance().remainingGold = remainingGold;
            return this;
        }

        public Builder withGoldPerRealm(List<GoldPerRealmDto> goldPerRealms) {
            instance().goldPerRealm = goldPerRealms;
            return this;
        }
    }

}
