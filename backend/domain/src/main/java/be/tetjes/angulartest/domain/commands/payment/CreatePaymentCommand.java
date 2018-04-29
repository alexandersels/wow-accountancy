package be.tetjes.angulartest.domain.commands.payment;

public class CreatePaymentCommand {


    private int price;
    private String player;
    private String realm;

    private CreatePaymentCommand() {

    }

    public int getPrice() {
        return price;
    }
    public String getPlayer() {return player;}
    public String getRealm() {return realm;}

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {

        private CreatePaymentCommand command = new CreatePaymentCommand();

        public Builder withPrice(int price) {
            command.price = price;
            return this;
        }

        public Builder withPlayer(String player) {
            command.player = player;
            return this;
        }

        public Builder withRealm(String realm) {
            command.realm = realm;
            return this;
        }

        public CreatePaymentCommand build() {
            return command;
        }
    }

}
