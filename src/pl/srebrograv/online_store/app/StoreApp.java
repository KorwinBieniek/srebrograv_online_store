package pl.srebrograv.online_store.app;

public class StoreApp {
    private static final String APP_NAME = "Srebrograv v1.5";

    public static void main(String[] args) {
        System.out.println(APP_NAME);
        StoreControl storeControl = new StoreControl();
        storeControl.controlLoop();

    }
}
