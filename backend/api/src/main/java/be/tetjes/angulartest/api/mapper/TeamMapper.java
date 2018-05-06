package be.tetjes.angulartest.api.mapper;

import be.tetjes.angulartest.api.dto.PlayerDto;
import be.tetjes.angulartest.api.dto.TeamDto;
import be.tetjes.angulartest.domain.entities.Player;
import be.tetjes.angulartest.iface.IPlayer;
import be.tetjes.angulartest.iface.ITeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class TeamMapper {

    @Autowired
    private PlayerMapper playerMapper;

    public TeamDto mapToDto(ITeam team, Collection<IPlayer> players) {
        return TeamDto.getBuilder()
                .withName(team.getName())
                .withMemberOne(findPlayer(team.getMemberOne(), players))
                .withMemberTwo(findPlayer(team.getMemberTwo(), players))
                .withMemberThree(findPlayer(team.getMemberThree(), players))
                .withMemberFour(findPlayer(team.getMemberFour(), players))
                .build();
    }

    private PlayerDto findPlayer(Long playerId, Collection<IPlayer> players) {
        Optional<IPlayer> optional = players.stream().filter(player -> player.getId() == playerId).findFirst();
        if (optional.isPresent()) {
            return playerMapper.mapToDto(optional.get());
        }
        return null;
    }
}
