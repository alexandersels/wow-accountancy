package be.tetjes.angulartest.domain.entities;

import be.tetjes.angulartest.domain.commands.player.CreatePlayerCommand;
import be.tetjes.angulartest.domain.commands.player.UpdatePlayerCommand;
import be.tetjes.angulartest.iface.IPlayer;
import be.tetjes.angulartest.infrastructure.BaseEntity;
import be.tetjes.angulartest.infrastructure.CommandHandler;
import be.tetjes.angulartest.infrastructure.CommandHandlerImpl;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Entity
@Table(name = "player")
public class Player extends BaseEntity implements IPlayer {

    public static Player createPlayer(CreatePlayerCommand command) {
        return builder()
                .withName(command.getName())
                .build();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    private Player() {
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    @Override
    protected List<CommandHandler> getCommandHandlers() {
        return newArrayList(new CommandHandlerImpl<>(UpdatePlayerCommand.class, this::update));
    }

    private void update(UpdatePlayerCommand command) {

    }

    public static Builder builder() {
        return new Builder();
    }

    private static class Builder extends BaseEntity.Builder<Player, Builder> {

        @Override
        protected Player createInstance() {
            return new Player();
        }

        public Builder withId(Long id) {
            instance().id = id;
            return this;
        }

        public Builder withName(String name) {
            instance().name = name;
            return this;
        }


    }

}
