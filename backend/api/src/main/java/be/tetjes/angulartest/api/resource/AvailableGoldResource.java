package be.tetjes.angulartest.api.resource;

import be.tetjes.angulartest.api.dto.AvailableGoldDto;
import be.tetjes.angulartest.api.mapper.AvailableGoldMapper;
import be.tetjes.angulartest.iface.IPlayer;
import be.tetjes.angulartest.iface.IRealm;
import be.tetjes.angulartest.infrastructure.AvailableGold;
import be.tetjes.angulartest.service.AvailableGoldService;
import be.tetjes.angulartest.service.PlayerService;
import be.tetjes.angulartest.service.RealmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class AvailableGoldResource {

    @Autowired
    private AvailableGoldMapper mapper;

    @Autowired
    private AvailableGoldService goldService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private RealmService realmService;

    @GetMapping("/availableGold")
    public AvailableGoldDto getAvailableGold() {

        Collection<IPlayer> players = playerService.getPlayers();
        Collection<IRealm> realms = realmService.getRealms();

        AvailableGold availableGold = goldService.getAvailableGold();
        return mapper.mapToDto(availableGold, realms, players);
    }

}
