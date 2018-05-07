package be.tetjes.angulartest.api.mapper;

import be.tetjes.angulartest.api.dto.AvailableGoldDto;
import be.tetjes.angulartest.iface.IPlayer;
import be.tetjes.angulartest.iface.IRealm;
import be.tetjes.angulartest.infrastructure.AvailableGold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.image.IndexColorModel;
import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class AvailableGoldMapper {

    @Autowired
    private GoldPerRealmMapper mapper;

    public AvailableGoldDto mapToDto(AvailableGold availableGold, Collection<IRealm> realms, Collection<IPlayer> players) {
        return AvailableGoldDto.getBuilder()
                .withGoldPerRealm(
                        availableGold.getGoldPerRealm()
                                .stream()
                                .map(g -> mapper.mapToDto(g, realms, players))
                                .collect(Collectors.toList())
                )
                .withTotalGold(availableGold.getTotalGold())
                .withRemainingGold(availableGold.getRemainingGold())
                .build();

    }
}
