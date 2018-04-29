package be.tetjes.angulartest.api.dto;

public class PaymentDto {

    public Long id;
    public int price;
    public int version;
    public String player;
    public String realm;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private PaymentDto payment;

        private Builder() {
            payment = new PaymentDto();
        }

        public Builder withId(Long id) {
            payment.id = id;
            return this;
        }

        public Builder withPrice(int price) {
            payment.price = price;
            return this;
        }

        public Builder withVersion(int version) {
            payment.version = version;
            return this;
        }

        public Builder withRealm(String realm) {
            payment.realm = realm;
            return this;
        }

        public Builder withPlayer(String player) {
            payment.player = player;
            return this;
        }

        public PaymentDto build() {
            return payment;
        }

    }
}
