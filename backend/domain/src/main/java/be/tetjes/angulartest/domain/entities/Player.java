package be.tetjes.angulartest.domain.entities;

import be.tetjes.angulartest.domain.commands.player.CreatePlayerCommand;
import be.tetjes.angulartest.iface.IPlayer;
import be.tetjes.angulartest.infrastructure.BaseEntity;
import be.tetjes.angulartest.infrastructure.CommandHandler;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "player")
public class Player extends BaseEntity implements IPlayer {

    public static Player createPlayer(CreatePlayerCommand command) {
        return builder()
                .withName(command.getName())
                .build();
    }

    @Id
    @Column(name = "name")
    @NotNull
    private String name;

    private Player() {
    }

    public String getName() {return name;}

    @Override
    protected List<CommandHandler> getCommandHandlers() {
        return new ArrayList<CommandHandler>();
    }

    public static Player.Builder builder() {
        return new Player.Builder();
    }

    private static class Builder extends BaseEntity.Builder<Player, Builder> {

        @Override
        protected Player createInstance() {
            return new Player();
        }

        public Player.Builder withName(String name) {
            instance().name = name;
            return this;
        }


    }

}
