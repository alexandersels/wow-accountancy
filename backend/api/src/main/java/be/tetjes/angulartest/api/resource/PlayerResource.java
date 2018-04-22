package be.tetjes.angulartest.api.resource;

import be.tetjes.angulartest.api.dto.PlayerDto;
import be.tetjes.angulartest.api.mapper.PlayerMapper;
import be.tetjes.angulartest.domain.commands.player.CreatePlayerCommand;
import be.tetjes.angulartest.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/player")
public class PlayerResource {

    @Autowired
    private PlayerService service;

    @Autowired
    private PlayerMapper mapper;

    @GetMapping
    public Collection<PlayerDto> getPlayers() {
        return new ArrayList<>();
    }

    @PutMapping
    public PlayerDto createPlayer(@RequestBody PlayerDto playerDto) {
        CreatePlayerCommand command = CreatePlayerCommand.of(playerDto.name);
        return mapper.mapToDto(service.createPlayer(command));
    }
}
