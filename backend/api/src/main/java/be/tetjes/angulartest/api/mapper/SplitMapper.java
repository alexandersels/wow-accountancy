package be.tetjes.angulartest.api.mapper;

import be.tetjes.angulartest.api.dto.PlayerDto;
import be.tetjes.angulartest.api.dto.SplitDto;
import be.tetjes.angulartest.iface.IPlayer;
import be.tetjes.angulartest.infrastructure.Split;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class SplitMapper {

    @Autowired
    private PlayerMapper playerMapper;


    public SplitDto mapToDto(Split split) {
        return SplitDto.getBuilder()
                .withPlayer(playerMapper.mapToDto(split.getPlayer()))
                .withAmountOfRuns(split.getAmountOfRuns())
                .withDebt(split.getDebt())
                .withTotalGoldEarned(split.getTotalGoldEarned())
                .build();
    }
}
