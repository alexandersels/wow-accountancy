package be.tetjes.angulartest.api.resource;

import be.tetjes.angulartest.api.dto.AvailableGoldDto;
import be.tetjes.angulartest.api.mapper.AvailableGoldMapper;
import be.tetjes.angulartest.infrastructure.AvailableGold;
import be.tetjes.angulartest.service.AvailableGoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvailableGoldResource {

    @Autowired
    private AvailableGoldMapper mapper;

    @Autowired
    private AvailableGoldService service;

    @GetMapping("/availableGold")
    public AvailableGoldDto getAvailableGold() {
        AvailableGold availableGold = service.getAvailableGold();
        return mapper.mapToDto(availableGold);
    }
}
