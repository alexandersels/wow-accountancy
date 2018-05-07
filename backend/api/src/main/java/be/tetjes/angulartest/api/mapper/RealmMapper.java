package be.tetjes.angulartest.api.mapper;

import be.tetjes.angulartest.api.dto.PlayerDto;
import be.tetjes.angulartest.api.dto.RealmDto;
import be.tetjes.angulartest.iface.IPlayer;
import be.tetjes.angulartest.iface.IRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class RealmMapper {

    @Autowired
    private PlayerMapper playerMapper;

    public RealmDto mapToDto(IRealm realm, Collection<IPlayer> players) {
        return RealmDto.builder()
                .withId(realm.getId())
                .withName(realm.getName())
                .withRegion(realm.getRegion())
                .withPlayer(findPlayer(realm.getPlayerId(), players))
                .withVersion(realm.getVersion())
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
