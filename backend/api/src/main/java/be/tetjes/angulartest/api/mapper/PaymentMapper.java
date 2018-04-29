package be.tetjes.angulartest.api.mapper;

import be.tetjes.angulartest.api.dto.IncomeDto;
import be.tetjes.angulartest.api.dto.PaymentDto;
import be.tetjes.angulartest.iface.IIncome;
import be.tetjes.angulartest.iface.IPayment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public PaymentDto mapToDto(IPayment income) {
        return PaymentDto.builder()
                .withId(income.getId())
                .withPrice(income.getPrice())
                .withPlayer(income.getPlayer())
                .withRealm(income.getRealm())
                .withVersion(income.getVersion())
                .build();
    }

}
