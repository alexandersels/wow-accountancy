package be.tetjes.angulartest.infrastructure;

public interface CommandHandler {
    boolean canHandle(Command command);

    void handle(Command command);
}
