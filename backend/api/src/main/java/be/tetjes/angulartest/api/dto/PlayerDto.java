package be.tetjes.angulartest.api.dto;

public class PlayerDto {

    public Long id;
    public String name;
    public int version;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private PlayerDto player;

        private Builder() {
            player = new PlayerDto();
        }

        public Builder withId(Long id) {
            player.id = id;
            return this;
        }

        public Builder withName(String name) {
            player.name = name;
            return this;
        }

        public Builder withVersion(int version) {
            player.version = version;
            return this;
        }

        public PlayerDto build() {
            return player;
        }
    }
}
