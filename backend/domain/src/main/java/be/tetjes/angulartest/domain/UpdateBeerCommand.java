package be.tetjes.angulartest.domain;

import be.tetjes.angulartest.infrastructure.Command;

public class UpdateBeerCommand extends Command {


    public static UpdateBeerCommand of(Long id, String name, int version) {
        return new UpdateBeerCommand(id, name, version);
    }

    private String name;

    private UpdateBeerCommand(Long id, String name, int version) {
        super(id, version);
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
