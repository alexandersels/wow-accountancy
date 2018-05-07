package be.tetjes.angulartest.domain.entities;

import be.tetjes.angulartest.domain.commands.income.CreateIncomeCommand;
import be.tetjes.angulartest.iface.IIncome;
import be.tetjes.angulartest.infrastructure.BaseEntity;
import be.tetjes.angulartest.infrastructure.CommandHandler;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "income")
public class Income extends BaseEntity implements IIncome {

    public static Income createIncome(CreateIncomeCommand command) {
        return getBuilder()
                .withDungeon(command.getDungeon())
                .withPrice(command.getPrice())
                .withDate(command.getDate())
                .withRealm(command.getRealm())
                .withTeam(command.getTeam())
                .build();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    @NotNull
    private Date date;

    @Column(name = "dungeon")
    @NotNull
    private String dungeon;

    @Column(name = "price")
    @NotNull
    private int price;

    @Column(name = "realm")
    private Long realm;

    @Column(name = "team")
    private Long team;

    private Income() {
    }

    @Override
    protected List<CommandHandler> getCommandHandlers() {
        return new ArrayList<CommandHandler>();
    }

    public Long getId() {
        return id;
    }

    public String getDungeon() {
        return dungeon;
    }

    public int getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }

    public Long getRealm() {
        return realm;
    }

    public Long getTeam() {
        return team;
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

        public Income.Builder withDate(Date date) {
            instance().date = date;
            return this;
        }

        public Income.Builder withRealm(Long realm) {
            instance().realm = realm;
            return this;
        }

        public Income.Builder withTeam(Long team) {
            instance().team = team;
            return this;
        }
    }
}
