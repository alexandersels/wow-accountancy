package be.tetjes.angulartest.api.mapper;

import be.tetjes.angulartest.api.dto.*;
import be.tetjes.angulartest.iface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class PaymentMapper {

    @Autowired
    private PlayerMapper playerMapper;

    @Autowired RealmMapper realmMapper;

    public PaymentDto mapToDto(IPayment income, Collection<IPlayer> players, Collection<IRealm> realms) {
        return PaymentDto.builder()
                .withId(income.getId())
                .withPrice(income.getPrice())
                .withPlayer(findPlayer(income.getPlayerId(), players))
                .withRealm(findRealm(income.getRealmId(), realms, players))
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

    private PlayerDto findPlayer(Long playerId, Collection<IPlayer> players) {
        Optional<IPlayer> optional = players.stream().filter(player -> player.getId() == playerId).findFirst();
        if (optional.isPresent()) {
            return playerMapper.mapToDto(optional.get());
        }
        return null;
    }

}
