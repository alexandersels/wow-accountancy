package be.tetjes.angulartest.api.mapper.statistics;

import be.tetjes.angulartest.api.dto.statistics.DungeonStatisticDto;
import be.tetjes.angulartest.api.dto.statistics.DungeonStatisticsDto;
import be.tetjes.angulartest.infrastructure.statistics.DungeonStatistic;
import be.tetjes.angulartest.infrastructure.statistics.DungeonStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class DungeonStatisticsMapper {

    @Autowired
    private DungeonStatisticMapper mapper;

    public DungeonStatisticsDto mapToDto(DungeonStatistics statistics) {
        ArrayList<DungeonStatisticDto> dungeons = new ArrayList<>();
        for(DungeonStatistic statistic : statistics.getDungeons()) {
            dungeons.add(mapper.mapToDto(statistic));
        }

        return DungeonStatisticsDto.getBuilder()
                .withDungeons(dungeons)
                .withTotalRuns(statistics.getTotalRuns())
                .build();
    }

}
