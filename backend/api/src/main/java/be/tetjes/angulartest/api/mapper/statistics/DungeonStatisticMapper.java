package be.tetjes.angulartest.api.mapper.statistics;

import be.tetjes.angulartest.api.dto.statistics.DungeonStatisticDto;
import be.tetjes.angulartest.infrastructure.statistics.DungeonStatistic;
import org.springframework.stereotype.Component;

@Component
public class DungeonStatisticMapper {

    public DungeonStatisticDto mapToDto(DungeonStatistic statistic) {
        return DungeonStatisticDto.getBuilder()
                .withAmountOfRuns(statistic.getAmountOfRuns())
                .withDungeonName(statistic.getDungeonName())
                .build();
    }

}
