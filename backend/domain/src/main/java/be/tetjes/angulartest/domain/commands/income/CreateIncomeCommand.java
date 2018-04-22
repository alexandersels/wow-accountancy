package be.tetjes.angulartest.domain.commands.income;

public class CreateIncomeCommand {

    public static CreateIncomeCommand of(String dungeon, int price) {
        return new CreateIncomeCommand(dungeon, price);
    }

    private int price;
    private String dungeon;

    private CreateIncomeCommand(String dungeon, int price) {
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
