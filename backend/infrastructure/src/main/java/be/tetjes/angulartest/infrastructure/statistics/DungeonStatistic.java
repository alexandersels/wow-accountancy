package be.tetjes.angulartest.infrastructure.statistics;

import be.tetjes.angulartest.infrastructure.NestedBuilder;

public class DungeonStatistic {

    private int amountOfRuns;
    private String dungeonName;

    private DungeonStatistic() {}

    public int getAmountOfRuns() {
        return amountOfRuns;
    }

    public String getDungeonName() {
        return dungeonName;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder extends NestedBuilder<DungeonStatistic> {


        public Builder withAmountOfRuns(int amountOfRuns) {
            instance().amountOfRuns = amountOfRuns;
            return this;
        }

        public Builder withDungeonName(String dungeonName) {
            instance().dungeonName = dungeonName;
            return this;
        }

        @Override
        protected DungeonStatistic createInstance() {
            return new DungeonStatistic();
        }
    }
}
