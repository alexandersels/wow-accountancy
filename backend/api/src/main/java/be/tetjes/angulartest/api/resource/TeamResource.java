package be.tetjes.angulartest.api.resource;

import be.tetjes.angulartest.api.dto.TeamDto;
import be.tetjes.angulartest.api.mapper.TeamMapper;
import be.tetjes.angulartest.domain.commands.team.CreateTeamCommand;
import be.tetjes.angulartest.domain.repositories.TeamRepository;
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
    private TeamService service;

    @GetMapping("/team")
    public Collection<TeamDto> getTeams() {
        return service.getTeams()
                .stream()
                .map(t -> mapper.mapToDto(t))
                .collect(Collectors.toList());
    }

    @GetMapping("/team/{name}")
    public TeamDto getTeam(@PathVariable String name) {
        return mapper.mapToDto(service.getTeam(name));
    }

    @PutMapping("/team")
    public TeamDto createTeam(@RequestBody TeamDto teamDto) {
        CreateTeamCommand command =CreateTeamCommand.getBuilder()
                .withName(teamDto.name)
                .withMemberOne(teamDto.memberOne)
                .withMemberTwo(teamDto.memberTwo)
                .withMemberThree(teamDto.memberThree)
                .withMemberFour(teamDto.memberFour)
                .build();
        return mapper.mapToDto(service.createTeam(command));

    }


}
