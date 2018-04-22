package be.tetjes.angulartest.domain.entities;

import be.tetjes.angulartest.domain.commands.income.CreateIncomeCommand;
import be.tetjes.angulartest.domain.commands.realm.CreateRealmCommand;
import be.tetjes.angulartest.iface.IIncome;
import be.tetjes.angulartest.iface.IRealm;
import be.tetjes.angulartest.infrastructure.BaseEntity;
import be.tetjes.angulartest.infrastructure.CommandHandler;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "income")
public class Income extends BaseEntity implements IIncome {

    public static Income createIncome(CreateIncomeCommand command) {
        return getBuilder()
                .withDungeon(command.getDungeon())
                .withPrice(command.getPrice())
                .build();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    private Long id;

    @Column(name = "dungeon")
    @NotNull
    private String dungeon;

    @Column(name = "price")
    @NotNull
    private int price;

    private Income() {
    }

    @Override
    protected List<CommandHandler> getCommandHandlers() {
        return new ArrayList<CommandHandler>();
    }

    public Long getId() {return id;}

    public String getDungeon() {
        return dungeon;
    }

    public int getPrice() {
        return price;
    }

    public static Income.Builder getBuilder() {
        return new Income.Builder();
    }

    private static class Builder extends BaseEntity.Builder<Income, Builder> {

        @Override
        protected Income createInstance() {
            return new Income();
        }

        public Income.Builder withDungeon(String dungeon) {
            instance().dungeon = dungeon;
            return this;
        }

        public Income.Builder withPrice(int price) {
            instance().price = price;
            return this;
        }
    }
}
