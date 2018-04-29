package be.tetjes.angulartest.api.dto;

import be.tetjes.angulartest.infrastructure.NestedBuilder;

public class PlayerDto {

    public String name;
    public int version;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends NestedBuilder<PlayerDto> {

        @Override
        protected PlayerDto createInstance() {
            return new PlayerDto();
        }

        public Builder withName(String name) {
            instance().name = name;
            return this;
        }

        public Builder withVersion(int version) {
            instance().version = version;
            return this;
        }

    }
}
