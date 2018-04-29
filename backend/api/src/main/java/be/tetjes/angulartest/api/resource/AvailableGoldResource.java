package be.tetjes.angulartest.api.resource;

import be.tetjes.angulartest.api.dto.AvailableGoldDto;
import be.tetjes.angulartest.iface.IIncome;
import be.tetjes.angulartest.iface.IRealm;
import be.tetjes.angulartest.service.IncomeService;
import be.tetjes.angulartest.service.RealmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AvailableGoldResource {

    @Autowired
    private RealmService realmService;

    @Autowired
    private IncomeService incomeService;

    @GetMapping("/availableGold")
    public AvailableGoldDto getAvilableGold() {
        List<IRealm> realms = realmService.getRealms();
        List<IIncome> incomes = incomeService.getIncomes();

        // Calculate

        // Mappertjeeuh

        return null;
    }
}
