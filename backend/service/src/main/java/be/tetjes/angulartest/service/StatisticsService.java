package be.tetjes.angulartest.service;

import be.tetjes.angulartest.iface.IIncome;
import be.tetjes.angulartest.infrastructure.statistics.DungeonStatistic;
import be.tetjes.angulartest.infrastructure.statistics.DungeonStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Service
public class StatisticsService {

    @Autowired
    private IncomeService incomeService;

    @Transactional
    public DungeonStatistics getDungeonStats() {

        int totalRuns = 0;
        HashMap<String, Integer> dungeons = new HashMap<>();

        for(IIncome income : incomeService.getIncomes()) {
            totalRuns++;
            String name = income.getDungeon();
            if(!dungeons.containsKey(name)) {
                dungeons.put(name, 0);
            }
            int runs = dungeons.get(name);
            dungeons.put(name, runs + 1);
        }

        ArrayList<DungeonStatistic> statistics = new ArrayList<>();
        for(String key: dungeons.keySet()) {
            int dungeonRuns = dungeons.get(key);
            DungeonStatistic statistic = DungeonStatistic.getBuilder()
                    .withAmountOfRuns(dungeonRuns)
                    .withDungeonName(key)
                    .build();
            statistics.add(statistic);
        }


        DungeonStatistics test = DungeonStatistics.getBuilder()
                .withTotalRuns(totalRuns)
                .withDungeons(statistics)
                .build();

        return test;
    }
}
