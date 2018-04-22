package be.tetjes.angulartest.infrastructure;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "version")
    @Version
    @NotNull
    protected int version;

    @Transient
    private final List<CommandHandler> commandHandlers = newArrayList();

    protected BaseEntity() {
        this.registerCommandHandlers();
    }

    private void registerCommandHandlers() {
        this.commandHandlers.addAll(this.getCommandHandlers());
    }

    protected List<CommandHandler> getCommandHandlers() {
        return newArrayList();
    }

    public void execute(Command command) {
        checkVersion(command);
        commandHandlers.stream()
                .filter(commandHandler -> commandHandler.canHandle(command))
                .forEach(commandHandler -> commandHandler.handle(command));
    }

    private void checkVersion(Command command) {
        if (this.version != command.getVersion()) {
            throw new OptimisticLockException(String.format("be.tetjes.angulartest.infrastructure.Command with version %s tried to adapt baseEntity %s with version %s. be.tetjes.angulartest.infrastructure.Command was %s.", command.getVersion(), this.getClass().getSimpleName(), getVersion(), command));
        }
    }

    public int getVersion() {
        return version;
    }

    public abstract static class Builder<T extends BaseEntity, B extends Builder<T, B>> extends NestedBuilder<T> {

        @SuppressWarnings("unchecked")
        public B withVersion(int version) {
            instance().version = version;
            return (B) this;
        }
    }

}
