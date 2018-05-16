package be.tetjes.angulartest.iface;

public interface IPayment {

    Long getId();

    int getPrice();

    Long getPlayerId();

    Long getRealmId();

    int getVersion();
}
