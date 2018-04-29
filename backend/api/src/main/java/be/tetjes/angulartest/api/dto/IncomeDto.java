package be.tetjes.angulartest.api.dto;

import be.tetjes.angulartest.infrastructure.NestedBuilder;

import java.util.Date;

public class IncomeDto {

    public Long id;
    public int price;
    public String dungeon;
    public int version;
    public Date date;
    public String realm;
    public String team;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends NestedBuilder<IncomeDto> {

        @Override
        protected IncomeDto createInstance() {
            return new IncomeDto();
        }

        public Builder withId(Long id) {
            instance().id = id;
            return this;
        }

        public Builder withPrice(int price) {
            instance().price = price;
            return this;
        }

        public Builder withDungeon(String dungeon) {
            instance().dungeon = dungeon;
            return this;
        }

        public Builder withVersion(int version) {
            instance().version = version;
            return this;
        }

        public Builder withDate(Date date) {
            instance().date = date;
            return this;
        }

        public Builder withRealm(String realm) {
            instance().realm = realm;
            return this;
        }

        public Builder withTeam(String team) {
            instance().team = team;
            return this;
        }

    }
}
