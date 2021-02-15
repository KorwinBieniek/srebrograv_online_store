package pl.srebrograv.online_store.model;

import pl.srebrograv.online_store.exception.CustomerAlreadyExistsException;
import pl.srebrograv.online_store.exception.ItemAlreadyExistsException;

import java.io.Serializable;
import java.util.*;

public class Store implements Serializable {

    private Map<String, Plate> plates = new HashMap<>();
    private Map<String, StoreCustomer> customers = new HashMap<>();

    public Map<String,Plate> getPlates() {
        return plates;
    }

    public Collection<Plate> getSortedPlates(Comparator<Plate> comparator) {
        ArrayList<Plate> listOfPlates = new ArrayList<>(this.plates.values());
        listOfPlates.sort(comparator);
        return listOfPlates;
    }

    public Map<String,StoreCustomer> getCustomers() {
        return customers;
    }

    public Collection<StoreCustomer> getSortedCustomers(Comparator<StoreCustomer> comparator) {
        ArrayList<StoreCustomer> listOfCustomers = new ArrayList<>(this.customers.values());
        listOfCustomers.sort(comparator);
        return listOfCustomers;
    }

    public void addUser(StoreCustomer customer) {
        if(customers.containsKey(customer.getPesel()))
            throw new CustomerAlreadyExistsException(
                    "The customer with the given pesel already exists in the database " + customer.getPesel()
            );
        customers.put(customer.getPesel(), customer);
    }

    public void addPlate(Plate plate) {
        if(plates.containsKey(plate.getPendantName()))
            throw new ItemAlreadyExistsException(
                    "The given plate already exists " + plate.getPendantName()
            );
            plates.put(plate.getPendantName(), plate);
    }

    public Optional<Plate> findPlateByName(String pendantName) {
        return Optional.ofNullable(plates.get(pendantName));
    }

    public boolean removePublication(Plate plate) {
        if(plates.containsValue(plate)) {
            plates.remove(plate.getPendantName());
            return true;
        } else {
            return false;
        }
    }


}
