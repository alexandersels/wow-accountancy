package be.tetjes.angulartest.beer;

public class BeerDto {
    public Long id;
    public String name;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private BeerDto beerDto;

        private Builder() {
            beerDto = new BeerDto();
        }

        public Builder withId(Long id) {
            beerDto.id = id;
            return this;
        }

        public Builder withName(String name) {
            beerDto.name = name;
            return this;
        }

        public BeerDto build() {
            return beerDto;
        }

    }
}
