package be.tetjes.angulartest.api.dto;

import be.tetjes.angulartest.infrastructure.NestedBuilder;

public class SplitDto {

    public PlayerDto player;
    public double debt;
    public int amountOfRuns;
    public int totalGoldEarned;

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder extends NestedBuilder<SplitDto> {

        @Override
        protected SplitDto createInstance() {
            return new SplitDto();
        }

        public Builder withPlayer(PlayerDto player) {
            instance().player = player;
            return this;
        }

        public Builder withDebt(double debt) {
            instance().debt = debt;
            return this;
        }

        public Builder withAmountOfRuns(int amountOfRuns) {
            instance().amountOfRuns = amountOfRuns;
            return this;
        }

        public Builder withTotalGoldEarned(int totalGoldEarned) {
            instance().totalGoldEarned = totalGoldEarned;
            return this;
        }

    }
}
