package pl.srebrograv.online_store.app;

import pl.srebrograv.online_store.exception.NoSuchOptionException;
import pl.srebrograv.online_store.io.ConsolePrinter;
import pl.srebrograv.online_store.io.DataReader;

import java.util.InputMismatchException;

public class StoreControl {

    ConsolePrinter printer = new ConsolePrinter();
    DataReader reader = new DataReader(printer);

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
