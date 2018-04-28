package be.tetjes.angulartest.domain.commands.income;

import java.util.Date;

public class CreateIncomeCommand {


    private int price;
    private String dungeon;
    private Date date;
    private String realm;

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

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {

        private CreateIncomeCommand command = new CreateIncomeCommand();

        public Builder withPrice(int price) {
            command.price = price;
            return this;
        }

        public Builder withDungeon(String dungeon) {
            command.dungeon = dungeon;
            return this;
        }

        public Builder withRealm(String realm) {
            command.realm = realm;
            return this;
        }

        public CreateIncomeCommand build() {
            return command;
        }
    }

}
