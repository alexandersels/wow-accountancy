package be.tetjes.angulartest.domain;

import be.tetjes.angulartest.iface.IBeer;
import be.tetjes.angulartest.infrastructure.BaseEntity;
import be.tetjes.angulartest.infrastructure.CommandHandler;
import be.tetjes.angulartest.infrastructure.CommandHandlerImpl;
import com.google.common.collect.Lists;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "beer")
public class Beer extends BaseEntity implements IBeer {

    public static Beer createBeer(CreateBeerCommand command) {
        return builder().withName(command.getName()).build();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private Long id;

    @Column(name = "name")
    @NotNull
    @Length(min = 6)
    private String name;

    private Beer() {
    }

    public Beer(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    protected List<CommandHandler> getCommandHandlers() {
        return Lists.newArrayList(new CommandHandlerImpl<>(UpdateBeerCommand.class, this::updateBeer));
    }

    private void updateBeer(UpdateBeerCommand updateBeerCommand) {
        id = updateBeerCommand.getId();
        name = updateBeerCommand.getName();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends BaseEntity.Builder<Beer, Builder> {

        @Override
        protected Beer createInstance() {
            return new Beer();
        }

        public Beer.Builder withId(Long id) {
            instance().id = id;
            return this;
        }

        public Beer.Builder withName(String name) {
            instance().name = name;
            return this;
        }
    }
}
