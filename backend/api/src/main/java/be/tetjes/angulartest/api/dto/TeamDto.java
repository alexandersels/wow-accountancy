package be.tetjes.angulartest.api.dto;

import be.tetjes.angulartest.infrastructure.NestedBuilder;

public class TeamDto {

    public Long id;
    public String name;
    public PlayerDto memberOne;
    public PlayerDto memberTwo;
    public PlayerDto memberThree;
    public PlayerDto memberFour;

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder extends NestedBuilder<TeamDto> {

        @Override
        protected TeamDto createInstance() {
            return new TeamDto();
        }

        public Builder withId(Long id) {
            instance().id = id;
            return this;
        }

        public Builder withName(String name) {
            instance().name = name;
            return this;
        }

        public Builder withMemberOne(PlayerDto memberOne) {
            instance().memberOne = memberOne;
            return this;
        }

        public Builder withMemberTwo(PlayerDto memberTwo) {
            instance().memberTwo = memberTwo;
            return this;
        }

        public Builder withMemberThree(PlayerDto memberThree) {
            instance().memberThree = memberThree;
            return this;
        }

        public Builder withMemberFour(PlayerDto memberFour) {
            instance().memberFour = memberFour;
            return this;
        }
    }


}
