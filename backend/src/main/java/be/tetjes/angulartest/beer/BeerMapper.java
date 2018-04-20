package be.tetjes.angulartest.beer;

import org.springframework.stereotype.Component;

@Component
public class BeerMapper {
    public BeerDto mapToDto(IBeer beer) {
        return BeerDto.builder()
                .withId(beer.getId())
                .withName(beer.getName())
                .build();
    }
}
