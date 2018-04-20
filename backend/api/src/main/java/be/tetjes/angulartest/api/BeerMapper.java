package be.tetjes.angulartest.api;

import be.tetjes.angulartest.iface.IBeer;
import org.springframework.stereotype.Component;

@Component
public class BeerMapper {
    public BeerDto mapToDto(IBeer beer) {
        return BeerDto.builder()
                .withId(beer.getId())
                .withName(beer.getName())
                .withVersion(beer.getVersion())
                .build();
    }
}
