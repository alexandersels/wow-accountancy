package be.tetjes.angulartest.api.mapper;

import be.tetjes.angulartest.api.dto.IncomeDto;
import be.tetjes.angulartest.api.dto.RealmDto;
import be.tetjes.angulartest.api.dto.TeamDto;
import be.tetjes.angulartest.iface.IIncome;
import be.tetjes.angulartest.iface.IPlayer;
import be.tetjes.angulartest.iface.IRealm;
import be.tetjes.angulartest.iface.ITeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class IncomeMapper {

    @Autowired
    private RealmMapper realmMapper;

    @Autowired
    private TeamMapper teamMapper;

    public IncomeDto mapToDto(IIncome income, Collection<IRealm> realms, Collection<IPlayer> players, Collection<ITeam> teams) {
        return IncomeDto.builder()
                .withId(income.getId())
                .withDate(income.getDate())
                .withDungeon(income.getDungeon())
                .withPrice(income.getPrice())
                .withRealm(findRealm(income.getRealmId(), realms, players))
                .withTeam(findTeam(income.getTeamId(), teams, players))
                .withVersion(income.getVersion())
                .build();
    }

    private RealmDto findRealm(Long realmId, Collection<IRealm> realms, Collection<IPlayer> players) {
        Optional<IRealm> optional = realms.stream().filter(realm -> realm.getId() == realmId).findFirst();
        if (optional.isPresent()) {
            return realmMapper.mapToDto(optional.get(), players);
        }
        return null;
    }

    private TeamDto findTeam(Long teamId, Collection<ITeam> teams, Collection<IPlayer> players) {
        Optional<ITeam> optional = teams.stream().filter(team -> team.getId() == teamId).findFirst();
        if (optional.isPresent()) {
            return teamMapper.mapToDto(optional.get(), players);
        }
        return null;
    }

}
