package be.tetjes.angulartest.domain.commands.player;

public class CreatePlayerCommand {

    public static CreatePlayerCommand of(String name) {
        return new CreatePlayerCommand(name);
    }

    private String name;

    private CreatePlayerCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



}
