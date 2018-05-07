package be.tetjes.angulartest.api.resource;

import be.tetjes.angulartest.api.dto.IncomeDto;
import be.tetjes.angulartest.api.mapper.IncomeMapper;
import be.tetjes.angulartest.domain.commands.income.CreateIncomeCommand;
import be.tetjes.angulartest.iface.IPlayer;
import be.tetjes.angulartest.iface.IRealm;
import be.tetjes.angulartest.iface.ITeam;
import be.tetjes.angulartest.service.IncomeService;
import be.tetjes.angulartest.service.PlayerService;
import be.tetjes.angulartest.service.RealmService;
import be.tetjes.angulartest.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class IncomeResource {

    @Autowired
    private IncomeMapper mapper;

    @Autowired
    private IncomeService incomeService;

    @Autowired
    private RealmService realmService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamService teamService;

    @GetMapping("/income")
    public Collection<IncomeDto> getIncomes() {

        Collection<IRealm> realms = realmService.getRealms();
        Collection<IPlayer> players = playerService.getPlayers();
        Collection<ITeam> teams = teamService.getTeams();

        return incomeService.getIncomes()
                .stream()
                .map(i -> mapper.mapToDto(i, realms, players, teams))
                .collect(Collectors.toList());
    }

    @GetMapping("/income/{id}")
    public IncomeDto getIncomes(@PathVariable Long id)
    {

        Collection<IRealm> realms = realmService.getRealms();
        Collection<IPlayer> players = playerService.getPlayers();
        Collection<ITeam> teams = teamService.getTeams();

        return mapper.mapToDto(incomeService.getIncome(id), realms, players, teams);
    }

    @PutMapping("/income")
    public void createRealm(@RequestBody IncomeDto incomeDto) {

        Collection<IRealm> realms = realmService.getRealms();
        Collection<IPlayer> players = playerService.getPlayers();
        Collection<ITeam> teams = teamService.getTeams();

        CreateIncomeCommand command = CreateIncomeCommand.getBuilder()
                .withPrice(incomeDto.price)
                .withDungeon(incomeDto.dungeon)
                .withRealm(incomeDto.realm.id)
                .withTeam(incomeDto.team.id)
                .build();

        incomeService.createIncome(command);
    }
}
