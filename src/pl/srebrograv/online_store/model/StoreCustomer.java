package pl.srebrograv.online_store.model;

import java.util.ArrayList;
import java.util.List;

public class StoreCustomer extends Customer {
    private List<Plate> plateHistory = new ArrayList<>();
    private List<Plate> purchasedPlates = new ArrayList<>();

    public List<Plate> getPlateHistory() {
        return plateHistory;
    }

    public List<Plate> getPurchasedPlates() {
        return purchasedPlates;
    }

    public StoreCustomer(String firstName, String lastName, String pesel) {
        super(firstName, lastName, pesel);
    }
}
