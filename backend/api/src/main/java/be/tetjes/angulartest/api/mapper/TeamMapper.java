package be.tetjes.angulartest.api.mapper;

import be.tetjes.angulartest.api.dto.TeamDto;
import be.tetjes.angulartest.iface.ITeam;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {

    public TeamDto mapToDto(ITeam team) {
        return TeamDto.getBuilder()
                .withName(team.getName())
                .withMemberOne(team.getMemberOne())
                .withMemberTwo(team.getMemberTwo())
                .withMemberThree(team.getMemberThree())
                .withMemberFour(team.getMemberFour())
                .build();
    }
}
