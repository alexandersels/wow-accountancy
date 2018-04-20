package be.tetjes.angulartest.infrastructure;

public abstract class Command {

    protected Long id;
    protected int version;

    protected Command(Long id, int version) {
        this.id = id;
        this.version =version;
    }

    public Long getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

}
