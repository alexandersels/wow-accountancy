package be.tetjes.angulartest.domain.commands.realm;

public class CreateRealmCommand {

    public static CreateRealmCommand of(String name, String region, String player) {
        return new CreateRealmCommand(name, region, player);
    }

    private String name;
    private String region;
    private String player;

    private CreateRealmCommand(String name, String region, String player) {

        this.name = name;
        this.region = region;
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getPlayer() {return player;}
}
