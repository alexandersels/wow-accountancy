package be.tetjes.angulartest.api.dto.statistics;

import be.tetjes.angulartest.infrastructure.NestedBuilder;

public class DungeonStatisticDto {

    public int amountOfRuns;
    public String dungeonName;

    private DungeonStatisticDto() {
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder extends NestedBuilder<DungeonStatisticDto> {


        @Override
        protected DungeonStatisticDto createInstance() {
            return new DungeonStatisticDto();
        }

        public Builder withAmountOfRuns(int amountOfRuns) {
            instance().amountOfRuns = amountOfRuns;
            return this;
        }

        public Builder withDungeonName(String dungeonName) {
            instance().dungeonName = dungeonName;
            return this;
        }
    }

}
