package be.tetjes.angulartest.api.dto;

import be.tetjes.angulartest.infrastructure.NestedBuilder;

import java.util.List;

public class AvailableGoldDto {

    public int price;
    public List<AvailableGoldPerRealmDto> goldPerRealm;

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder extends NestedBuilder<AvailableGoldDto>
    {

        @Override
        protected AvailableGoldDto createInstance() {
            return new AvailableGoldDto();
        }

        public Builder withPrice(int price) {
            instance().price = price;
            return this;
        }

        public Builder withGoldPerRealms(List<AvailableGoldPerRealmDto> goldPerRealms) {
            instance().goldPerRealm = goldPerRealms;
            return this;
        }
    }

}
