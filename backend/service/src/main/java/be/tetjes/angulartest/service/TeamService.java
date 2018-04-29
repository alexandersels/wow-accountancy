package be.tetjes.angulartest.service;

import be.tetjes.angulartest.domain.commands.team.CreateTeamCommand;
import be.tetjes.angulartest.domain.entities.Team;
import be.tetjes.angulartest.domain.repositories.TeamRepository;
import be.tetjes.angulartest.iface.ITeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class TeamService {

    @Autowired
    private TeamRepository repository;

    @Transactional
    public Collection<ITeam> getTeams() {
        return repository.findAll()
                .stream()
                .map(Team.class::cast)
                .collect(Collectors.toList());
    }

    @Transactional
    public ITeam getTeam(String name) {
        return repository.findOne(name);
    }

    @Transactional
    public ITeam createTeam(CreateTeamCommand command) {
        return repository.save(Team.createTeam(command));
    }

    @Transactional
    public Collection<ITeam> getTeamsForPlayer(String playerName) {
        return repository.findAll()
                .stream()
                .filter(team -> isPlayerMemberOf(team, playerName))
                .map(Team.class::cast)
                .collect(Collectors.toList());
    }

    private boolean isPlayerMemberOf(ITeam team, String playerName) {
        return team.getMemberOne().equals(playerName) ||
                team.getMemberTwo().equals(playerName) ||
                team.getMemberThree().equals(playerName) ||
                team.getMemberFour().equals(playerName);
    }
}
