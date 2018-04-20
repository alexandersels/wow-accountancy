package be.tetjes.angulartest.infrastructure;

import be.tetjes.angulartest.beer.Command;

public interface CommandHandler {
    boolean canHandle(Command command);

    void handle(Command command);
}
