package be.tetjes.angulartest.api.resource;

import be.tetjes.angulartest.api.dto.RealmDto;
import be.tetjes.angulartest.api.mapper.RealmMapper;
import be.tetjes.angulartest.domain.commands.realm.CreateRealmCommand;
import be.tetjes.angulartest.iface.IPlayer;
import be.tetjes.angulartest.service.PlayerService;
import be.tetjes.angulartest.service.RealmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class RealmResource {

    @Autowired
    private RealmMapper mapper;

    @Autowired
    private RealmService realmService;

    @Autowired
    private PlayerService playerService;

    @GetMapping("/realm")
    public Collection<RealmDto> getRealms()
    {
        Collection<IPlayer> players = playerService.getPlayers();
        return realmService.getRealms()
                .stream()
                .map(r -> mapper.mapToDto(r, players))
                .collect(Collectors.toList());
    }

    @GetMapping("/realm/{name}")
    public RealmDto getRealm(@PathVariable String name)
    {
        Collection<IPlayer> players = playerService.getPlayers();
        return mapper.mapToDto(realmService.getRealm(name), players);
    }

    @PutMapping("/realm")
    public void createRealm(@RequestBody RealmDto realmDto) {
        CreateRealmCommand command = CreateRealmCommand.of(realmDto.name, realmDto.region, realmDto.player.id);
        realmService.createRealm(command);
    }


}
