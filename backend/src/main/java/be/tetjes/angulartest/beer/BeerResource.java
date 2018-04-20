package be.tetjes.angulartest.beer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/beer")
public class BeerResource {

    @Autowired
    private BeerService beerService;

    @Autowired
    private BeerMapper beerMapper;


    @GetMapping
    public Collection<BeerDto> getBeers() {
        return beerService.findAll().stream()
                .map(beer -> beerMapper.mapToDto(beer))
                .collect(toList());
    }

//    @GetMapping("/{beerId}")
//    public Collection<BeerDto> getBeer(@PathVariable("beerId") String beerId) {
//        return beerMapper.mapToDto(beerService.find(beerId));
//    }

//    @PostMapping
//    public BeerDto updateBeer(@RequestBody BeerDto beerDto) {
//
//    }

    private boolean isGreat(Beer beer) {
        return !beer.getName().equals("stront");
    }
}
