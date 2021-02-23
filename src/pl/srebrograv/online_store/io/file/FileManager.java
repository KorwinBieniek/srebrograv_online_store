package pl.srebrograv.online_store.io.file;

import pl.srebrograv.online_store.model.Store;

public interface FileManager {
    Store importData();
    void exportData(Store library);
}
