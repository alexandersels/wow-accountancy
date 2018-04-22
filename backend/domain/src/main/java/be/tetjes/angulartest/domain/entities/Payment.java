package be.tetjes.angulartest.domain.entities;

import be.tetjes.angulartest.domain.commands.income.CreateIncomeCommand;
import be.tetjes.angulartest.domain.commands.payment.CreatePaymentCommand;
import be.tetjes.angulartest.iface.IIncome;
import be.tetjes.angulartest.iface.IPayment;
import be.tetjes.angulartest.infrastructure.BaseEntity;
import be.tetjes.angulartest.infrastructure.CommandHandler;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "income")
public class Payment extends BaseEntity implements IPayment {

    public static Payment createPayment(CreatePaymentCommand command) {
        return getBuilder()
                .withPrice(command.getPrice())
                .build();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    private Long id;


    @Column(name = "price")
    @NotNull
    private int price;

    private Payment() {
    }

    @Override
    protected List<CommandHandler> getCommandHandlers() {
        return new ArrayList<CommandHandler>();
    }

    public Long getId() {return id;}


    public int getPrice() {
        return price;
    }

    public static Payment.Builder getBuilder() {
        return new Payment.Builder();
    }

    private static class Builder extends BaseEntity.Builder<Payment, Builder> {

        @Override
        protected Payment createInstance() {
            return new Payment();
        }

        public Payment.Builder withPrice(int price) {
            instance().price = price;
            return this;
        }
    }
}
