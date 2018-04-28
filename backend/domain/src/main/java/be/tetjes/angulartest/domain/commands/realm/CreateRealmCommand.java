package be.tetjes.angulartest.domain.commands.realm;

import be.tetjes.angulartest.domain.entities.Player;

public class CreateRealmCommand {

    public static CreateRealmCommand of(String name, String region, Long playerId) {
        return new CreateRealmCommand(name, region, playerId);
    }

    private String name;
    private String region;
    private Long playerId;

    private CreateRealmCommand(String name, String region, Long playerId) {

        this.name = name;
        this.region = region;
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public Long getPlayerId() {
        return playerId;
    }
}
