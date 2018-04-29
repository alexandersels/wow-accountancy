package be.tetjes.angulartest.api.dto;

import be.tetjes.angulartest.infrastructure.NestedBuilder;

public class TeamDto {

    public String name;
    public String memberOne;
    public String memberTwo;
    public String memberThree;
    public String memberFour;

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder extends NestedBuilder<TeamDto> {

        @Override
        protected TeamDto createInstance() {
            return new TeamDto();
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
            instance(). memberThree =  memberThree;
            return this;
        }

        public Builder withMemberFour(String memberFour) {
            instance().memberFour = memberFour;
            return this;
        }
    }


}
