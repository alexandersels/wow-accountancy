package be.tetjes.angulartest.api.mapper;

import be.tetjes.angulartest.api.dto.RealmDto;
import be.tetjes.angulartest.iface.IRealm;
import org.springframework.stereotype.Component;

@Component
public class RealmMapper {

    public RealmDto mapToDto(IRealm realm) {
        return RealmDto.builder()
                .withName(realm.getName())
                .withRegion(realm.getRegion())
                .withVersion(realm.getVersion())
                .build();
    }

}
