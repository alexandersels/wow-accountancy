package be.tetjes.angulartest.api.resource;

import be.tetjes.angulartest.api.dto.RealmDto;
import be.tetjes.angulartest.api.mapper.RealmMapper;
import be.tetjes.angulartest.domain.commands.realm.CreateRealmCommand;
import be.tetjes.angulartest.service.RealmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/realm")
public class RealmResource {

    @Autowired
    private RealmMapper mapper;

    @Autowired
    private RealmService service;

    @GetMapping
    public Collection<RealmDto> getRealms() {
        return new ArrayList<>();
    }

    @PutMapping
    public RealmDto createRealm(@RequestBody RealmDto realmDto) {
        CreateRealmCommand command = CreateRealmCommand.of(realmDto.name, realmDto.region);
        return mapper.mapToDto(service.createRealm(command));
    }
}
