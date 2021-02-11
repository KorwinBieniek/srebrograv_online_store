package pl.srebrograv.online_store.app;

import pl.srebrograv.online_store.exception.NoSuchOptionException;

public class StoreControl {


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
