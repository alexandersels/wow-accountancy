package be.tetjes.angulartest.domain.commands.realm;

public class CreateRealmCommand {

    public static CreateRealmCommand of(String name, String region) {
        return new CreateRealmCommand(name, region);
    }

    private String name;
    private String region;

    private CreateRealmCommand(String name, String region) {

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
