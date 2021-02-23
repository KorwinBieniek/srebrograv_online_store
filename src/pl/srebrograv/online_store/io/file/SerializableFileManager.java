package pl.srebrograv.online_store.io.file;

import pl.srebrograv.online_store.exception.DataExportException;
import pl.srebrograv.online_store.exception.DataImportException;
import pl.srebrograv.online_store.model.Store;

import java.io.*;

public class SerializableFileManager implements FileManager {
    private static final String FILE_NAME = "Store.o";

    //@Override
    public void exportData(Store store) {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos);
        ){
            oos.writeObject(store);
        } catch (FileNotFoundException e) {
            throw new DataExportException("No file " + FILE_NAME);
        } catch (IOException e) {
            throw new DataExportException("Error while saving data " + FILE_NAME);
        }
    }

    //@Override
    public Store importData() {
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            return (Store) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new DataImportException("No file " + FILE_NAME);
        } catch (IOException e) {
            throw new DataImportException("Error while loading data " + FILE_NAME);
        } catch (ClassNotFoundException e) {
            throw new DataImportException("Wrong type of file " + FILE_NAME);
        }
    }
}
