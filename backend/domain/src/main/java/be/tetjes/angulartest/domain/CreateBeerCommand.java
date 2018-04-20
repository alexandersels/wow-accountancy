package be.tetjes.angulartest.domain;

public class CreateBeerCommand {

    private String name;


    private CreateBeerCommand(String name) {
        this.name = name;
    }

    public static CreateBeerCommand of(String name) {
        return new CreateBeerCommand(name);
    }
    
    public String getName() {
        return name;
    }


}
