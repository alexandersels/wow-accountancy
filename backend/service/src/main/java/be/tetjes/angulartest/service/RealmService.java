package be.tetjes.angulartest.service;

import be.tetjes.angulartest.domain.commands.realm.CreateRealmCommand;
import be.tetjes.angulartest.domain.entities.Realm;
import be.tetjes.angulartest.domain.repositories.RealmRepository;
import be.tetjes.angulartest.iface.IRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class RealmService {

    @Autowired
    private RealmRepository repository;

    @Transactional
    public List<IRealm> findAll() {
        return repository.findAll().stream()
                .map(Realm.class::cast)
                .collect(toList());
    }

    @Transactional
    public IRealm createRealm(CreateRealmCommand command){
        return repository.save(Realm.createRealm(command));
    }
}
