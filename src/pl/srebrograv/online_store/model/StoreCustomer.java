package pl.srebrograv.online_store.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public String toCsv() {
        return getFirstName() + ";" + getLastName() + ";" + getPesel();
    }

    private void addPlateToPurchases(Plate pub) {
        plateHistory.add(pub);
    }

    public void purchasePlate(Plate pub) {
        purchasedPlates.add(pub);
    }

    public boolean returnPublication(Plate pub) {
        boolean result = false;
        if (purchasedPlates.remove(pub)) {
            result = true;
            addPlateToPurchases(pub);
        }
        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StoreCustomer that = (StoreCustomer) o;
        return Objects.equals(plateHistory, that.plateHistory) &&
                Objects.equals(purchasedPlates, that.purchasedPlates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), plateHistory, purchasedPlates);
    }
}
