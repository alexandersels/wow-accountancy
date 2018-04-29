package be.tetjes.angulartest.api.dto;

public class RealmDto {

    public String name;
    public String region;
    public int version;
    public String player;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private RealmDto realm;

        private Builder() {
            realm = new RealmDto();
        }

        public Builder withName(String name) {
            realm.name = name;
            return this;
        }

        public Builder withRegion(String region) {
            realm.region = region;
            return this;
        }

        public Builder withVersion(int version) {
            realm.version = version;
            return this;
        }

        public Builder withPlayerId(String player) {
            realm.player = player;
            return this;
        }

        public RealmDto build() {
            return realm;
        }

    }
}
