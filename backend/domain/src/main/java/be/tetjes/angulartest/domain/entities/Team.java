package be.tetjes.angulartest.domain.entities;

import be.tetjes.angulartest.domain.commands.team.CreateTeamCommand;
import be.tetjes.angulartest.iface.ITeam;
import be.tetjes.angulartest.infrastructure.BaseEntity;
import be.tetjes.angulartest.infrastructure.NestedBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Team extends BaseEntity implements ITeam {

    public static Team createTeam(CreateTeamCommand command) {
        return getBuilder()
                .withName(command.getName())
                .withMemberOne(command.getMemberOne())
                .withMemberTwo(command.getMemberTwo())
                .withMemberThree(command.getMemberThree())
                .withMemberFour(command.getMemberFour())
                .build();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "memberOne")
    @NotNull
    private Long memberOne;

    @Column(name = "memberTwo")
    @NotNull
    private Long memberTwo;

    @Column(name = "memberThree")
    @NotNull
    private Long memberThree;

    @Column(name = "memberFour")
    @NotNull
    private Long memberFour;

    public Long getId() {return id;}

    public String getName() {
        return name;
    }

    public Long getMemberOne() {
        return memberOne;
    }

    public Long getMemberTwo() {
        return memberTwo;
    }

    public Long getMemberThree() {
        return memberThree;
    }

    public Long getMemberFour() {
        return memberFour;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder extends NestedBuilder<Team> {

        @Override
        protected Team createInstance() {
            return new Team();
        }

        public Builder withName(String name) {
            instance().name = name;
            return this;
        }

        public Builder withId(Long id) {
            instance().id = id;
            return this;
        }

        public Builder withMemberOne(Long memberOne) {
            instance().memberOne = memberOne;
            return this;
        }

        public Builder withMemberTwo(Long memberTwo) {
            instance().memberTwo = memberTwo;
            return this;
        }

        public Builder withMemberThree(Long memberThree) {
            instance().memberThree = memberThree;
            return this;
        }
        public Builder withMemberFour(Long memberFour) {
            instance().memberFour = memberFour;
            return this;
        }

    }
}
