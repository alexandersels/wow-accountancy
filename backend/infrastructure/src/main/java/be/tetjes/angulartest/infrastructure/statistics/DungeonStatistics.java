package be.tetjes.angulartest.infrastructure.statistics;

import be.tetjes.angulartest.infrastructure.NestedBuilder;

import java.util.Collection;

public class DungeonStatistics {

    private int totalRuns;
    private Collection<DungeonStatistic> dungeons;

    private DungeonStatistics() {}

    public int getTotalRuns() {
        return totalRuns;
    }

    public Collection<DungeonStatistic> getDungeons() {
        return dungeons;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder extends NestedBuilder<DungeonStatistics> {

        public Builder withTotalRuns(int totalRuns) {
            instance().totalRuns = totalRuns;
            return this;
        }

        public Builder withDungeons(Collection<DungeonStatistic> dungeons) {
            instance().dungeons = dungeons;
            return this;
        }

        @Override
        protected DungeonStatistics createInstance() {
            return new DungeonStatistics();
        }
    }

}
