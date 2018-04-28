package be.tetjes.angulartest.api.resource;

import be.tetjes.angulartest.api.dto.PlayerDto;
import be.tetjes.angulartest.api.dto.RealmDto;
import be.tetjes.angulartest.api.mapper.RealmMapper;
import be.tetjes.angulartest.domain.commands.realm.CreateRealmCommand;
import be.tetjes.angulartest.service.RealmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class RealmResource {

    @Autowired
    private RealmMapper mapper;

    @Autowired
    private RealmService service;

    @GetMapping("/realm")
    public Collection<RealmDto> getRealms() {
        return service.findAll()
                .stream()
                .map(r -> mapper.mapToDto(r))
                .collect(Collectors.toList());
    }

    @GetMapping("/realm/{name}")
    public RealmDto getRealm(@PathVariable String name) {
        return mapper.mapToDto(service.getRealm(name));
    }

    @PutMapping("/realm")
    public RealmDto createRealm(@RequestBody RealmDto realmDto) {
        CreateRealmCommand command = CreateRealmCommand.of(realmDto.name, realmDto.region, realmDto.playerId);
        return mapper.mapToDto(service.createRealm(command));
    }


}
