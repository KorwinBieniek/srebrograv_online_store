package pl.srebrograv.online_store.io.file;

import pl.srebrograv.online_store.exception.DataExportException;
import pl.srebrograv.online_store.exception.DataImportException;
import pl.srebrograv.online_store.exception.InvalidDataException;
import pl.srebrograv.online_store.model.*;

import java.io.*;
import java.util.Collection;

public class CsvFileManager implements FileManager {
    private static final String PLATES_FILE_NAME = "Store.csv";
    private static final String CUSTOMERS_FILE_NAME = "Store_customers.csv";

    @Override
    public void exportData(Store store) {
        exportPublications(store);
        exportUsers(store);
    }

    @Override
    public Store importData() {
        Store store = new Store();
        importPublications(store);
        importUsers(store);
        return store;
    }

    private void exportPublications(Store store) {
        Collection<Plate> plates = store.getPlates().values();
        exportPlatesToCsv(plates, PLATES_FILE_NAME);
    }

    private void exportUsers(Store store) {
        Collection<StoreCustomer> customers = store.getCustomers().values();
        exportCustomersToCsv(customers, CUSTOMERS_FILE_NAME);
    }

    private <T extends CsvConvertible> void exportPlatesToCsv(Collection<Plate> collection, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Plate element : collection) {
                bufferedWriter.write(element.toCsv());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new DataExportException("Cannot save changes to the file " + fileName);
        }
    }

    private <T extends CsvConvertible> void exportCustomersToCsv(Collection<StoreCustomer> collection, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (StoreCustomer element : collection) {
                bufferedWriter.write(element.toCsv());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new DataExportException("Cannot save changes to the file " + fileName);
        }
    }


    private void importPublications(Store store) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PLATES_FILE_NAME))) {
            bufferedReader.lines()
                    .map(this::createObjectFromString)
                    .forEach(store::addPlate);
        } catch (FileNotFoundException e) {
            throw new DataImportException("No file " + PLATES_FILE_NAME);
        } catch (IOException e) {
            throw new DataImportException("Cannot read file " + PLATES_FILE_NAME);
        }
    }

    private Plate createObjectFromString(String csvText) {
        String[] split = csvText.split(";");
        String type = split[0];
        if(Xeranthemum.TYPE.equals(type)) {
            return createXeranthemum(split);
        } else if(Bracelet.TYPE.equals(type)) {
            return createBracelet(split);
        }
        throw new InvalidDataException("Unknown plate type: " + type);
    }

    private Xeranthemum createXeranthemum(String[] data) {
        String pendantType = data[1];
        String metalType = data[2];
        String engravingMessage = data[3];
        return new Xeranthemum(pendantType, metalType, engravingMessage );
    }

    private Bracelet createBracelet(String[] data) {
        String pendantType = data[1];
        String metalType = data[2];
        String strapType = data[3];
        return new Bracelet(pendantType, metalType, strapType );
    }

    private void importUsers(Store library) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(CUSTOMERS_FILE_NAME))) {
            bufferedReader.lines()
                    .map(this::createCustomerFromString)
                    .forEach(library::addUser);
        } catch (FileNotFoundException e) {
            throw new DataImportException("No file " + CUSTOMERS_FILE_NAME);
        } catch (IOException e) {
            throw new DataImportException("Cannot read file " + CUSTOMERS_FILE_NAME);
        }

    }

    private StoreCustomer createCustomerFromString(String csvText) {
        String[] split = csvText.split(";");
        String firstName = split[0];
        String lastName = split[1];
        String pesel = split[2];
        return new StoreCustomer(firstName, lastName, pesel);
    }
}
