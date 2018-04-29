package be.tetjes.angulartest.api.dto;

import be.tetjes.angulartest.infrastructure.NestedBuilder;

public class PaymentDto {

    public Long id;
    public int price;
    public int version;
    public String player;
    public String realm;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends NestedBuilder<PaymentDto> {

        @Override
        protected PaymentDto createInstance() {
            return new PaymentDto();
        }

        public Builder withId(Long id) {
            instance().id = id;
            return this;
        }

        public Builder withPrice(int price) {
            instance().price = price;
            return this;
        }

        public Builder withVersion(int version) {
            instance().version = version;
            return this;
        }

        public Builder withRealm(String realm) {
            instance().realm = realm;
            return this;
        }

        public Builder withPlayer(String player) {
            instance().player = player;
            return this;
        }

    }
}
