package be.tetjes.angulartest.domain.commands.payment;

public class CreatePaymentCommand {

    public static CreatePaymentCommand of(int price) {
        return new CreatePaymentCommand(price);
    }

    private int price;

    private CreatePaymentCommand(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

}
