package be.tetjes.angulartest.domain.entities;

import be.tetjes.angulartest.domain.commands.team.CreateTeamCommand;
import be.tetjes.angulartest.iface.ITeam;
import be.tetjes.angulartest.infrastructure.BaseEntity;
import be.tetjes.angulartest.infrastructure.NestedBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
    @Column(name = "name")
    private String name;

    @Column(name = "memberOne")
    private String memberOne;

    @Column(name = "memberTwo")
    private String memberTwo;

    @Column(name = "memberThree")
    private String memberThree;

    @Column(name = "memberFour")
    private String memberFour;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getMemberOne() {
        return memberOne;
    }

    @Override
    public String getMemberTwo() {
        return memberTwo;
    }

    @Override
    public String getMemberThree() {
        return memberThree;
    }

    @Override
    public String getMemberFour() {
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

        public Builder withMemberOne(String memberOne) {
            instance().memberOne = memberOne;
            return this;
        }

        public Builder withMemberTwo(String memberTwo) {
            instance().memberTwo = memberTwo;
            return this;
        }

        public Builder withMemberThree(String memberThree) {
            instance().memberThree = memberThree;
            return this;
        }
        public Builder withMemberFour(String memberFour) {
            instance().memberFour = memberFour;
            return this;
        }

    }
}
