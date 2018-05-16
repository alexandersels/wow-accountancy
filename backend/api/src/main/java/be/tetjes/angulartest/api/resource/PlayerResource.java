package be.tetjes.angulartest.api.resource;

import be.tetjes.angulartest.api.dto.PlayerDto;
import be.tetjes.angulartest.api.mapper.PlayerMapper;
import be.tetjes.angulartest.domain.commands.player.CreatePlayerCommand;
import be.tetjes.angulartest.iface.IPlayer;
import be.tetjes.angulartest.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class PlayerResource {

    @Autowired
    private PlayerService service;

    @Autowired
    private PlayerMapper mapper;

    @GetMapping("/player")
    public Collection<PlayerDto> getPlayers() {
        return service.getPlayers()
                .stream()
                .map(p -> mapper.mapToDto(p))
                .collect(Collectors.toList());
    }

    @GetMapping("/player/{id}")
    public PlayerDto getPlayer(@PathVariable Long id) {
        return mapper.mapToDto(service.getPlayer(id));
    }

    @PutMapping("/player")
    public void createPlayer(@RequestBody PlayerDto playerDto) {
        CreatePlayerCommand command = CreatePlayerCommand.of(playerDto.name);
        service.createPlayer(command);
    }
}
