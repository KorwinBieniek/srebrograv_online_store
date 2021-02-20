package pl.srebrograv.online_store.app;

import pl.srebrograv.online_store.exception.CustomerAlreadyExistsException;
import pl.srebrograv.online_store.exception.NoSuchOptionException;
import pl.srebrograv.online_store.io.ConsolePrinter;
import pl.srebrograv.online_store.io.DataReader;
import pl.srebrograv.online_store.model.*;

import java.util.Comparator;
import java.util.InputMismatchException;

public class StoreControl {

    ConsolePrinter printer = new ConsolePrinter();
    DataReader reader = new DataReader(printer);

    private Store store;

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while(!optionOk) {
            try {
                option = Option.createFromInt(reader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage() + ", podaj ponownie:");
            } catch (InputMismatchException ignored) {
                printer.printLine("Wprowadzono wartość, która nie jest liczbą, podaj ponownie:");
            }
        }
        return option;
    }

    private void printOptions() {
        System.out.println("Choose option");
        for (Option options : Option.values()) {
            printer.printLine(options.toString());
        }
    }

    void controlLoop() {
        Option option;

        do {
            printOptions();
            option = getOption();
            switch (option) {
                case ADD_BRACELET:

                    break;
                case ADD_XERANTHEMUM:

                    break;
                case PRINT_BRACELETS:

                    break;
                case PRINT_XERANTHEMUMS:

                    break;
                case DELETE_BRACELET:

                    break;
                case DELETE_XERANTHEMUM:

                    break;
                case ADD_CUSTOMER:

                    break;
                case PRINT_CUSTOMERS:

                    break;
                case FIND_PRODUCT:

                    break;
                case EXIT:

                    break;
                default:
                    printer.printLine("Nie ma takiej opcji, wprowadź ponownie: ");
            }
        } while (option != Option.EXIT);
    }

    private void addBracelet() {
        try {
            Bracelet bracelet = reader.readAndCreateBracelet();
            store.addPlate(bracelet);
        } catch (InputMismatchException e) {
            printer.printLine("Unable to create a plate, wrong input data");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Maximal capacity reached. Unable to add another plate");
        }
    }

    private void addXeranthemum() {
        try {
            Xeranthemum xeranthemum = reader.readAndCreateXeranthemum();
            store.addPlate(xeranthemum);
        } catch (InputMismatchException e) {
            printer.printLine("Unable to create a plate, wrong input data");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Maximal capacity reached. Unable to add another plate");
        }
    }

    private void addCustomer() {
        StoreCustomer storeCustomer = reader.createStoreCustomer();
        try {
            store.addUser(storeCustomer);
        } catch (CustomerAlreadyExistsException e) {
            printer.printLine(e.getMessage());
        }
    }

    private void printXeranthemum() {
        printer.printPlates(store.getSortedPlates(
                Comparator.comparing(Plate::getPendantName, String.CASE_INSENSITIVE_ORDER))
        );
    }

    private void printBracelets() {
        printer.printPlates(store.getSortedPlates(
                Comparator.comparing(Plate::getPendantName, String.CASE_INSENSITIVE_ORDER)
        ));
    }

    private void printCustomers() {
        printer.printCustomers(store.getSortedCustomers(
                Comparator.comparing(Customer::getLastName, String.CASE_INSENSITIVE_ORDER)
        ));
    }

    private enum Option {
        EXIT(0, "Exit the program"),
        ADD_BRACELET(1, "Add bracelet"),
        ADD_XERANTHEMUM(2, "Add xeranthemum"),
        PRINT_BRACELETS(3, "Print available bracelets"),
        PRINT_XERANTHEMUMS(4, "Print available xeranthemums"),
        DELETE_BRACELET(5, "Remove bracelet"),
        DELETE_XERANTHEMUM(6, "Remove xeranthemum"),
        ADD_CUSTOMER(7, "Add the customer"),
        PRINT_CUSTOMERS(8, "Display customers"),
        FIND_PRODUCT(9, "Find the product");


        private int enumValue;
        private String enumDescription;

        Option(int enumValue, String enumDescription) {
            this.enumValue = enumValue;
            this.enumDescription = enumDescription;
        }

        @Override
        public String toString() {
            return enumValue + " - " + enumDescription;
        }

        static Option createFromInt(int option) throws NoSuchOptionException {
            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("Brak opcji o id " + option);
            }
        }
    }
}
