package be.tetjes.angulartest.domain.commands.payment;

import be.tetjes.angulartest.infrastructure.Command;

public class UpdatePaymentCommand extends Command {

    public static UpdatePaymentCommand of(Long id, int price, int version) {
        return new UpdatePaymentCommand(id, price, version);
    }

    private int price;

    private UpdatePaymentCommand(Long id, int price, int version) {
        super(id, version);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
