package be.tetjes.angulartest.api.dto;

public class PlayerDto {

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
