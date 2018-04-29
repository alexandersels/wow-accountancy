package be.tetjes.angulartest.api.mapper;

import be.tetjes.angulartest.api.dto.GoldPerRealmDto;
import be.tetjes.angulartest.infrastructure.GoldPerRealm;
import org.springframework.stereotype.Component;

@Component
public class GoldPerRealmMapper {

    public GoldPerRealmDto mapToDto(GoldPerRealm goldPerRealm) {
        return GoldPerRealmDto.builder()
                .withGold(goldPerRealm.getGold())
                .withPlayer(goldPerRealm.getPlayer())
                .withRealm(goldPerRealm.getRealm())
                .build();
    }
}
