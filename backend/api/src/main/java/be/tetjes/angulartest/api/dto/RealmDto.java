package be.tetjes.angulartest.api.dto;

import be.tetjes.angulartest.infrastructure.NestedBuilder;

public class RealmDto {

    public Long id;
    public String name;
    public String region;
    public int version;
    public PlayerDto player;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends NestedBuilder<RealmDto> {

        @Override
        protected RealmDto createInstance() {
            return new RealmDto();
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

        public Builder withVersion(int version) {
            instance().version = version;
            return this;
        }

        public Builder withPlayer(PlayerDto player) {
            instance().player = player;
            return this;
        }

    }
}
