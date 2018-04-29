package be.tetjes.angulartest.api.resource;

import be.tetjes.angulartest.api.dto.SplitDto;
import be.tetjes.angulartest.api.mapper.SplitMapper;
import be.tetjes.angulartest.service.SplitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class SplitResource {

    @Autowired
    private SplitService splitService;

    @Autowired
    private SplitMapper mapper;

    @GetMapping("/split")
    public Collection<SplitDto> getSplits() {
        return  splitService.getSplits()
                .stream()
                .map(s -> mapper.mapToDto(s))
                .collect(Collectors.toList());
    }

    @GetMapping("/split/{name}")
    public SplitDto getSplit(@PathVariable String name) {
        return mapper.mapToDto(splitService.getSplit(name));
    }

}
