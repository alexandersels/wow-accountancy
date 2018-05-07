package be.tetjes.angulartest.domain.entities;

import be.tetjes.angulartest.domain.commands.realm.CreateRealmCommand;
import be.tetjes.angulartest.iface.IRealm;
import be.tetjes.angulartest.infrastructure.BaseEntity;
import be.tetjes.angulartest.infrastructure.CommandHandler;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "realm")
public class Realm extends BaseEntity implements IRealm {

    public static Realm createRealm(CreateRealmCommand command) {
        return getBuilder()
                .withName(command.getName())
                .withRegion(command.getRegion())
                .withPlayerId(command.getPlayerId())
                .build();
    }

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "region")
    @NotNull
    private String region;

    @JoinColumn(name = "playerId")
    private Long playerId;

    private Realm() {
    }

    @Override
    protected List<CommandHandler> getCommandHandlers() {
        return new ArrayList<CommandHandler>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {

        return name;
    }

    public String getRegion() {

        return region;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public static Realm.Builder getBuilder() {
        return new Realm.Builder();
    }

    private static class Builder extends BaseEntity.Builder<Realm, Builder> {

        @Override
        protected Realm createInstance() {
            return new Realm();
        }

        public Builder withId(Long id) {
            instance().id = id;
            return this;
        }

        public Builder withName(String name) {
            instance().name = name;
            return this;
        }

        public Builder withRegion(String region) {
            instance().region = region;
            return this;
        }

        public Builder withPlayerId(Long playerId) {
            instance().playerId = playerId;
            return this;
        }
    }
}
