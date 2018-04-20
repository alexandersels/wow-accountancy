package be.tetjes.angulartest.beer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Service
public class BeerService {

    @Autowired
    private BeerRepository repository;

    @Transactional
    public List<IBeer> findAll() {
        Stream.of("Test1", "Test2", "Test3", "Test4").forEach((name -> repository.save(new Beer(name))));

        return repository.findAll().stream()
                .map(Beer.class::cast)
                .collect(toList());
    }

//    @Transactional
//    public IBeer updateBeer(UpdateBeerCommand command){
//        Beer beer = repository.findOne(command.getBeerId());
//        beer.execute(command);
//        return repository.save(beer);
//    }
}
