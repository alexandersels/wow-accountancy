package be.tetjes.angulartest.api.resource;

import be.tetjes.angulartest.api.dto.PaymentDto;
import be.tetjes.angulartest.api.mapper.PaymentMapper;
import be.tetjes.angulartest.domain.commands.payment.CreatePaymentCommand;
import be.tetjes.angulartest.iface.IPlayer;
import be.tetjes.angulartest.iface.IRealm;
import be.tetjes.angulartest.service.PaymentService;
import be.tetjes.angulartest.service.PlayerService;
import be.tetjes.angulartest.service.RealmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class PaymentResource {

    @Autowired
    private PaymentMapper mapper;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private RealmService realmService;

    @GetMapping("/payment")
    public Collection<PaymentDto> getPayments()
    {
        Collection<IPlayer> players = playerService.getPlayers();
        Collection<IRealm> realms = realmService.getRealms();

        return paymentService.getPayments()
                .stream()
                .map(p -> mapper.mapToDto(p, players, realms))
                .collect(Collectors.toList());
    }

    @GetMapping("/payment/{id}")
    public PaymentDto getPayment(@PathVariable Long id)
    {
        Collection<IPlayer> players = playerService.getPlayers();
        Collection<IRealm> realms = realmService.getRealms();

        return mapper.mapToDto(paymentService.getById(id), players, realms);
    }

    @PutMapping("/payment")
    public void createPayment(@RequestBody PaymentDto paymentDto)
    {
        CreatePaymentCommand command = CreatePaymentCommand.getBuilder()
                .withPlayer(paymentDto.player.id)
                .withPrice(paymentDto.price)
                .withRealm(paymentDto.realm.id)
                .build();

        paymentService.createPayment(command);
    }
}
