package be.tetjes.angulartest.api.resource;

import be.tetjes.angulartest.api.dto.statistics.DungeonStatisticsDto;
import be.tetjes.angulartest.api.mapper.statistics.DungeonStatisticsMapper;
import be.tetjes.angulartest.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsResource {

    @Autowired
    private StatisticsService service;

    @Autowired
    private DungeonStatisticsMapper mapper;

    @GetMapping("/dungeonStatistics")
    public DungeonStatisticsDto getDungeonStatistics() {
        return mapper.mapToDto(service.getDungeonStats());
    }
}
