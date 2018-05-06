package be.tetjes.angulartest.api.dto.statistics;

import be.tetjes.angulartest.infrastructure.NestedBuilder;

import java.util.Collection;

public class DungeonStatisticsDto {

    public int totalRuns;
    public Collection<DungeonStatisticDto> dungeons;

    private DungeonStatisticsDto() {

    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder extends NestedBuilder<DungeonStatisticsDto> {

        @Override
        protected DungeonStatisticsDto createInstance() {
            return new DungeonStatisticsDto();
        }

        public Builder withTotalRuns(int totalRuns) {
            instance().totalRuns = totalRuns;
            return this;
        }

        public Builder withDungeons(Collection<DungeonStatisticDto> dungeons) {
            instance().dungeons = dungeons;
            return this;
        }

    }


}
