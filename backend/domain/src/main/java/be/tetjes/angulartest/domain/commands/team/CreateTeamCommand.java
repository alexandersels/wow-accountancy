package be.tetjes.angulartest.domain.commands.team;

import be.tetjes.angulartest.domain.entities.Player;
import be.tetjes.angulartest.infrastructure.NestedBuilder;

public class CreateTeamCommand {

    private String name;
    private Long memberOne;
    private Long memberTwo;
    private Long memberThree;
    private Long memberFour;


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

    public static class Builder extends NestedBuilder<CreateTeamCommand> {

        @Override
        protected CreateTeamCommand createInstance() {
            return new CreateTeamCommand();
        }

        public Builder withName(String name) {
            instance().name = name;
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
