package be.tetjes.angulartest.domain.commands.team;

import be.tetjes.angulartest.infrastructure.NestedBuilder;

public class CreateTeamCommand {

    private String name;
    private String memberOne;
    private String memberTwo;
    private String memberThree;
    private String memberFour;


    public String getName() {
        return name;
    }

    public String getMemberOne() {
        return memberOne;
    }

    public String getMemberTwo() {
        return memberTwo;
    }

    public String getMemberThree() {
        return memberThree;
    }

    public String getMemberFour() {
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
