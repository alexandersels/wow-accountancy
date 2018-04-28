package be.tetjes.angulartest.api.dto;

import java.util.Date;

public class IncomeDto {

    public Long id;
    public int price;
    public String dungeon;
    public int version;
    public Date date;
    public String realm;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private IncomeDto income;

        private Builder() {
            income = new IncomeDto();
        }

        public Builder withId(Long id) {
            income.id = id;
            return this;
        }

        public Builder withPrice(int price) {
            income.price = price;
            return this;
        }

        public Builder withDungeon(String dungeon) {
            income.dungeon = dungeon;
            return this;
        }

        public Builder withVersion(int version) {
            income.version = version;
            return this;
        }

        public Builder withDate(Date date) {
            income.date = date;
            return this;
        }

        public Builder withRealm(String realm) {
            income.realm = realm;
            return this;
        }

        public IncomeDto build() {
            return income;
        }

    }
}
