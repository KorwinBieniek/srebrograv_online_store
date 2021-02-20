package pl.srebrograv.online_store.io;

import pl.srebrograv.online_store.model.Customer;
import pl.srebrograv.online_store.model.Plate;
import pl.srebrograv.online_store.model.StoreCustomer;

import java.util.Collection;
import java.util.Objects;

public class ConsolePrinter {
    public void printPlates(Collection<Plate> plates) {
        long count = plates.stream()
                .filter(Objects::nonNull)
                .map(Plate::toString)
                .peek(this::printLine)
                .count();
        if (count == 0) {
            System.out.println("No plates in the store");
        }
    }

    public void printCustomers(Collection<StoreCustomer> users) {
        users.stream()
                .map(Customer::toString)
                .forEach(this::printLine);
    }

    public void printLine(String text) {
        System.out.println(text);
    }
}
