package be.tetjes.angulartest.domain.commands.payment;

public class CreatePaymentCommand {


    private int price;
    private Long player;
    private Long realm;

    private CreatePaymentCommand() {

    }

    public int getPrice() {
        return price;
    }
    public Long getPlayer() {return player;}
    public Long getRealm() {return realm;}

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {

        private CreatePaymentCommand command = new CreatePaymentCommand();

        public Builder withPrice(int price) {
            command.price = price;
            return this;
        }

        public Builder withPlayer(Long player) {
            command.player = player;
            return this;
        }

        public Builder withRealm(Long realm) {
            command.realm = realm;
            return this;
        }

        public CreatePaymentCommand build() {
            return command;
        }
    }

}
