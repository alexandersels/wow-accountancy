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
                .build();
    }

    @Id
    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "region")
    @NotNull
    private String region;

    private Realm() {
    }

    @Override
    protected List<CommandHandler> getCommandHandlers() {
        return new ArrayList<CommandHandler>();
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public static Realm.Builder getBuilder() {
        return new Realm.Builder();
    }

    private static class Builder extends BaseEntity.Builder<Realm, Builder> {

        @Override
        protected Realm createInstance() {
            return new Realm();
        }

        public Realm.Builder withName(String name) {
            instance().name = name;
            return this;
        }

        public Realm.Builder withRegion(String region) {
            instance().region = region;
            return this;
        }
    }
}
