package be.tetjes.angulartest.domain.entities;

import be.tetjes.angulartest.domain.commands.payment.CreatePaymentCommand;
import be.tetjes.angulartest.iface.IPayment;
import be.tetjes.angulartest.infrastructure.BaseEntity;
import be.tetjes.angulartest.infrastructure.CommandHandler;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "payment")
public class Payment extends BaseEntity implements IPayment {

    public static Payment createPayment(CreatePaymentCommand command) {
        return getBuilder()
                .withPrice(command.getPrice())
                .withPlayer(command.getPlayer())
                .withRealm(command.getRealm())
                .build();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "price")
    @NotNull
    private int price;

    @Column(name = "player")
    @NotNull
    private Long player;

    @Column(name = "realm")
    @NotNull
    private Long realm;

    private Payment() {
    }

    @Override
    protected List<CommandHandler> getCommandHandlers() {
        return new ArrayList<CommandHandler>();
    }

    public Long getId() {
        return id;
    }

    public Long getPlayer() {
        return player;
    }

    public Long getRealm() {
        return realm;
    }

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

        public Payment.Builder withPlayer(Long player) {
            instance().player = player;
            return this;
        }

        public Payment.Builder withRealm(Long realm) {
            instance().realm = realm;
            return this;
        }


    }
}
