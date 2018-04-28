package be.tetjes.angulartest.api.resource;

import be.tetjes.angulartest.api.dto.IncomeDto;
import be.tetjes.angulartest.api.mapper.IncomeMapper;
import be.tetjes.angulartest.domain.commands.income.CreateIncomeCommand;
import be.tetjes.angulartest.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class IncomeResource {

    @Autowired
    private IncomeMapper mapper;

    @Autowired
    private IncomeService service;

    @GetMapping("/income")
    public Collection<IncomeDto> getIncomes() {
        return service.findAll()
                .stream()
                .map(i -> mapper.mapToDto(i))
                .collect(Collectors.toList());
    }

    @GetMapping("/income/{id}")
    public IncomeDto getIncomes(@PathVariable Long id) {
        return mapper.mapToDto(service.getIncome(id));
    }

    @PutMapping("/income")
    public IncomeDto createRealm(@RequestBody IncomeDto incomeDto) {
        CreateIncomeCommand command = CreateIncomeCommand.getBuilder()
                .withPrice(incomeDto.price)
                .withDungeon(incomeDto.dungeon)
                .withRealm(incomeDto.realm)
                .build();
        return mapper.mapToDto(service.createIncome(command));
    }
}
