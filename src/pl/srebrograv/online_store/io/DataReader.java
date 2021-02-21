package pl.srebrograv.online_store.io;

import pl.srebrograv.online_store.model.Bracelet;
import pl.srebrograv.online_store.model.StoreCustomer;
import pl.srebrograv.online_store.model.Xeranthemum;

import java.util.Scanner;

public class DataReader {
    private Scanner sc = new Scanner(System.in);
    private ConsolePrinter printer;

    public DataReader(ConsolePrinter printer) {
        this.printer = printer;
    }

    public void close() {
        sc.close();
    }

    public int getInt() {
        try {
            return sc.nextInt();
        } finally {
            sc.nextLine();
        }
    }

    public String getString() {
        return sc.nextLine();
    }

    public Xeranthemum readAndCreateXeranthemum() {
        printer.printLine("Pendant name: ");
        String pendantName = sc.nextLine();
        printer.printLine("Metal type: ");
        String metalType = sc.nextLine();
        printer.printLine("Engravement message: ");
        String engravementMessage = sc.nextLine();

        return new Xeranthemum(pendantName, metalType, engravementMessage);
    }

    public Bracelet readAndCreateBracelet() {
        printer.printLine("Pendant name: ");
        String pendantName = sc.nextLine();
        printer.printLine("Metal type: ");
        String metalType = sc.nextLine();
        printer.printLine("Strap type: ");
        String StrapType = sc.nextLine();

        return new Bracelet(pendantName, metalType, StrapType);
    }

    public StoreCustomer createStoreCustomer() {
        printer.printLine("Name");
        String firstName = sc.nextLine();
        printer.printLine("Last name");
        String lastName = sc.nextLine();
        printer.printLine("Pesel");
        String pesel = sc.nextLine();
        return new StoreCustomer(firstName, lastName, pesel);
    }

}