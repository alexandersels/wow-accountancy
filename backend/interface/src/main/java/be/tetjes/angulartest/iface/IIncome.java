package be.tetjes.angulartest.iface;

import java.util.Date;

public interface IIncome {

    Long getId();

    Date getDate();

    int getPrice();

    String getDungeon();

    int getVersion();

    Long getRealm();

    Long getTeam();
}
