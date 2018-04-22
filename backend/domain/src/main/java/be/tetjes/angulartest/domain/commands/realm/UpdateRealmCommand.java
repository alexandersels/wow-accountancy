package be.tetjes.angulartest.domain.commands.realm;

import be.tetjes.angulartest.infrastructure.Command;

public class UpdateRealmCommand extends Command {

    public static UpdateRealmCommand of(Long id, String name, String region, int version) {
        return new UpdateRealmCommand(id, name, region, version);
    }

    private String name;
    private String region;

    private UpdateRealmCommand(Long id, String name, String region, int version) {
        super(id, version);
        this.name = name;
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }
}
