package be.tetjes.angulartest.domain.commands.player;

import be.tetjes.angulartest.infrastructure.Command;

public class UpdatePlayerCommand extends Command {

    public static UpdatePlayerCommand of(Long id, String name, int version) {
        return new UpdatePlayerCommand(id, name, version);
    }

    private String name;

    private UpdatePlayerCommand(Long id, String name, int version) {
        super(id, version);
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
