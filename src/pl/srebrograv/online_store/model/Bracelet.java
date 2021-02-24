package pl.srebrograv.online_store.model;

public class Bracelet extends Plate implements CsvConvertible {
    private String strapType;
    public static final String TYPE = "Bracelet";

    public Bracelet(String pendantName, String metalType, String strapType) {
        super(pendantName, metalType);
        this.strapType = strapType;
    }

    public String getStrapType() {
        return strapType;
    }

    public void setStrapType(String strapType) {
        this.strapType = strapType;
    }

    @Override
    public String toCsv() {
        return (TYPE + ";") +
                getPendantName() + ";" +
                getMetalType() + ";" +
                getStrapType();
    }

}
