package be.tetjes.angulartest.api.mapper;

import be.tetjes.angulartest.api.dto.PlayerDto;
import be.tetjes.angulartest.iface.IPlayer;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {

    public PlayerDto mapToDto(IPlayer player) {
        return PlayerDto.builder()
                .withName(player.getName())
                .withVersion(player.getVersion())
                .build();
    }

}
