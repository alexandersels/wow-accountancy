package be.tetjes.angulartest.api.mapper;

import be.tetjes.angulartest.api.dto.IncomeDto;
import be.tetjes.angulartest.api.dto.PlayerDto;
import be.tetjes.angulartest.iface.IIncome;
import be.tetjes.angulartest.iface.IPlayer;
import org.springframework.stereotype.Component;

@Component
public class IncomeMapper {

    public IncomeDto mapToDto(IIncome income) {
        return IncomeDto.builder()
                .withId(income.getId())
                .withDungeon(income.getDungeon())
                .withPrice(income.getPrice())
                .withVersion(income.getVersion())
                .build();
    }

}
