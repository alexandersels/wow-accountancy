package be.tetjes.angulartest.api.resource;

import be.tetjes.angulartest.api.dto.PaymentDto;
import be.tetjes.angulartest.api.mapper.PaymentMapper;
import be.tetjes.angulartest.domain.commands.payment.CreatePaymentCommand;
import be.tetjes.angulartest.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class PaymentResource {

    @Autowired
    private PaymentMapper mapper;

    @Autowired
    private PaymentService service;

    @GetMapping("/payment")
    public Collection<PaymentDto> getPayments() {
        return service.getPayments()
                .stream()
                .map(p -> mapper.mapToDto(p))
                .collect(Collectors.toList());
    }

    @GetMapping("/payment/{id}")
    public PaymentDto getPayment(@PathVariable Long id) {
        return mapper.mapToDto(service.getById(id));
    }

    @PutMapping("/payment")
    public PaymentDto createPayment(@RequestBody PaymentDto paymentDto) {
        CreatePaymentCommand command = CreatePaymentCommand.getBuilder()
                .withPlayer(paymentDto.player)
                .withPrice(paymentDto.price)
                .withRealm(paymentDto.realm)
                .build();
        return mapper.mapToDto(service.createPayment(command));
    }
}
