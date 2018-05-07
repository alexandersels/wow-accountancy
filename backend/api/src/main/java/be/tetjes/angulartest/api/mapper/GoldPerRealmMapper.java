package be.tetjes.angulartest.api.mapper;

import be.tetjes.angulartest.api.dto.GoldPerRealmDto;
import be.tetjes.angulartest.api.dto.PlayerDto;
import be.tetjes.angulartest.api.dto.RealmDto;
import be.tetjes.angulartest.iface.IPlayer;
import be.tetjes.angulartest.iface.IRealm;
import be.tetjes.angulartest.infrastructure.GoldPerRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class GoldPerRealmMapper {

    @Autowired
    private PlayerMapper playerMapper;

    @Autowired
    private RealmMapper realmMapper;

    public GoldPerRealmDto mapToDto(GoldPerRealm goldPerRealm, Collection<IRealm> realms, Collection<IPlayer> players) {
        return GoldPerRealmDto.builder()
                .withGold(goldPerRealm.getGold())
                .withPlayer(findPlayer(goldPerRealm.getPlayerId(), players))
                .withRealm(findRealm(goldPerRealm.getRealmId(), realms, players))
                .build();
    }

    private PlayerDto findPlayer(Long playerId, Collection<IPlayer> players) {
        Optional<IPlayer> optional = players.stream().filter(player -> player.getId() == playerId).findFirst();
        if (optional.isPresent()) {
            return playerMapper.mapToDto(optional.get());
        }
        return null;
    }

    private RealmDto findRealm(Long realmId, Collection<IRealm> realms, Collection<IPlayer> players) {
        Optional<IRealm> optional = realms.stream().filter(realm -> realm.getId() == realmId).findFirst();
        if (optional.isPresent()) {
            return realmMapper.mapToDto(optional.get(), players);
        }
        return null;
    }
}
