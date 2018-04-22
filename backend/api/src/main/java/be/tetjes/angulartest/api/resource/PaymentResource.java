package be.tetjes.angulartest.api.resource;

import be.tetjes.angulartest.api.dto.IncomeDto;
import be.tetjes.angulartest.api.dto.PaymentDto;
import be.tetjes.angulartest.api.dto.RealmDto;
import be.tetjes.angulartest.api.mapper.IncomeMapper;
import be.tetjes.angulartest.api.mapper.PaymentMapper;
import be.tetjes.angulartest.domain.commands.payment.CreatePaymentCommand;
import be.tetjes.angulartest.domain.commands.realm.CreateRealmCommand;
import be.tetjes.angulartest.service.IncomeService;
import be.tetjes.angulartest.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/payment")
public class PaymentResource {

    @Autowired
    private PaymentMapper mapper;

    @Autowired
    private PaymentService service;

    @GetMapping
    public Collection<PaymentDto> getPayments() {
        return new ArrayList<>();
    }

    @PutMapping
    public PaymentDto createPayment(@RequestBody PaymentDto paymentDto) {
        CreatePaymentCommand command = CreatePaymentCommand.of(paymentDto.price);
        return mapper.mapToDto(service.createPayment(command));
    }
}
