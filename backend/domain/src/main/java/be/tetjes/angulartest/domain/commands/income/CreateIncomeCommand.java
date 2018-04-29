package be.tetjes.angulartest.domain.commands.income;

import be.tetjes.angulartest.infrastructure.NestedBuilder;

import java.util.Date;

public class CreateIncomeCommand {


    private int price;
    private String dungeon;
    private Date date;
    private String realm;
    private String team;

    private CreateIncomeCommand() {
        this.date = new Date();
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

    public String getRealm() {
        return realm;
    }

    public String getTeam() { return team; }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder extends NestedBuilder<CreateIncomeCommand> {

        @Override
        protected CreateIncomeCommand createInstance() {
            return new CreateIncomeCommand();
        }

        public Builder withPrice(int price) {
            instance().price = price;
            return this;
        }

        public Builder withDungeon(String dungeon) {
            instance().dungeon = dungeon;
            return this;
        }

        public Builder withRealm(String realm) {
            instance().realm = realm;
            return this;
        }

        public Builder withTeam(String team) {
            instance().team = team;
            return this;
        }
    }

}
