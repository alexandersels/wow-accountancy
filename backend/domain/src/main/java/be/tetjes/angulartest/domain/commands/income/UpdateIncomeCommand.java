package be.tetjes.angulartest.domain.commands.income;

import be.tetjes.angulartest.infrastructure.Command;

public class UpdateIncomeCommand extends Command {

    public static UpdateIncomeCommand of(Long id, String dungeon, int price, int version) {
        return new UpdateIncomeCommand(id, dungeon, price, version);
    }

    private String dungeon;
    private int price;

    private UpdateIncomeCommand(Long id, String dungeon, int price, int version) {
        super(id, version);
        this.dungeon = dungeon;
        this.price = price;
    }

    public String getDungeon() {
        return dungeon;
    }

    public int getPrice() {
        return price;
    }
}
