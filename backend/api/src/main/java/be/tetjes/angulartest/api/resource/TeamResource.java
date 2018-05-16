package be.tetjes.angulartest.api.resource;

import be.tetjes.angulartest.api.dto.TeamDto;
import be.tetjes.angulartest.api.mapper.TeamMapper;
import be.tetjes.angulartest.domain.commands.team.CreateTeamCommand;
import be.tetjes.angulartest.iface.IPlayer;
import be.tetjes.angulartest.service.PlayerService;
import be.tetjes.angulartest.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class TeamResource {

    @Autowired
    private TeamMapper mapper;

    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerService playerService;

    @GetMapping("/team")
    public Collection<TeamDto> getTeams() {
        Collection<IPlayer> players = playerService.getPlayers();
        return teamService.getTeams()
                .stream()
                .map(t -> mapper.mapToDto(t, players))
                .collect(Collectors.toList());
    }

    @GetMapping("/team/{id}")
    public TeamDto getTeam(@PathVariable Long id) {
        Collection<IPlayer> players = playerService.getPlayers();
        return mapper.mapToDto(teamService.getTeam(id), players);
    }

    @PutMapping("/team")
    public void createTeam(@RequestBody TeamDto teamDto) {
        CreateTeamCommand command =CreateTeamCommand.getBuilder()
                .withName(teamDto.name)
                .withMemberOne(teamDto.memberOne.id)
                .withMemberTwo(teamDto.memberTwo.id)
                .withMemberThree(teamDto.memberThree.id)
                .withMemberFour(teamDto.memberFour.id)
                .build();

        teamService.createTeam(command);
    }


}
