package be.tetjes.angulartest.service;

import be.tetjes.angulartest.domain.commands.player.CreatePlayerCommand;
import be.tetjes.angulartest.domain.entities.Player;
import be.tetjes.angulartest.domain.repositories.PlayerRepository;
import be.tetjes.angulartest.iface.IPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    @Transactional
    public Collection<IPlayer> getPlayers() {
        return repository.findAll().stream()
                .map(Player.class::cast)
                .collect(toList());
    }

    @Transactional
    public IPlayer createPlayer(CreatePlayerCommand command) {
        return repository.save(Player.createPlayer(command));
    }

    @Transactional
    public IPlayer getPlayer(String name) {
        return repository.findOne(name);
    }

}
