package be.tetjes.angulartest.iface;

public interface IPayment {
    Long getId();
    int getPrice();
    String getPlayer();
    String getRealm();
    int getVersion();
}
