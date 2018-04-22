package be.tetjes.angulartest.api.resource;

import be.tetjes.angulartest.api.dto.IncomeDto;
import be.tetjes.angulartest.api.dto.RealmDto;
import be.tetjes.angulartest.api.mapper.IncomeMapper;
import be.tetjes.angulartest.api.mapper.RealmMapper;
import be.tetjes.angulartest.domain.commands.income.CreateIncomeCommand;
import be.tetjes.angulartest.domain.commands.realm.CreateRealmCommand;
import be.tetjes.angulartest.service.IncomeService;
import be.tetjes.angulartest.service.RealmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/income")
public class IncomeResource {

    @Autowired
    private IncomeMapper mapper;

    @Autowired
    private IncomeService service;

    @GetMapping
    public Collection<IncomeDto> getRealms() {
        return new ArrayList<>();
    }

    @PutMapping
    public IncomeDto createRealm(@RequestBody IncomeDto incomeDto) {
        CreateIncomeCommand command = CreateIncomeCommand.of(incomeDto.dungeon, incomeDto.price);
        return mapper.mapToDto(service.createIncome(command));
    }
}
