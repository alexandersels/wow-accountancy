package be.tetjes.angulartest.infrastructure;

import be.tetjes.angulartest.beer.Command;

import java.util.function.Consumer;

public class CommandHandlerImpl<C extends Command> implements CommandHandler {

    private Class<C> acceptedCommandType;
    private Consumer<C> doHandle;

    public CommandHandlerImpl(Class<C> acceptedCommandType, Consumer<C> doHandle) {
        this.acceptedCommandType = acceptedCommandType;
        this.doHandle = doHandle;
    }

    @Override
    public boolean canHandle(Command command) {
        return acceptedCommandType.isAssignableFrom(command.getClass());
    }

    @Override
    @SuppressWarnings("unchecked")
    public void handle(Command command) {
        doHandle.accept((C) command);
    }
}

