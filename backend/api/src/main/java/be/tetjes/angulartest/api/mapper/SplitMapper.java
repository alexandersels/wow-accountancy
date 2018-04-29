package be.tetjes.angulartest.api.mapper;

import be.tetjes.angulartest.api.dto.SplitDto;
import be.tetjes.angulartest.infrastructure.Split;
import org.springframework.stereotype.Component;

@Component
public class SplitMapper {

    public SplitDto mapToDto(Split split) {
        return SplitDto.getBuilder()
                .withPlayerName(split.getPlayerName())
                .withAmountOfRuns(split.getAmountOfRuns())
                .withDebt(split.getDebt())
                .withTotalGoldEarned(split.getTotalGoldEarned())
                .build();
    }
}
