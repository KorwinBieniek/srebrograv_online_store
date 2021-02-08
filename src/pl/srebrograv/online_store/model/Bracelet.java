package pl.srebrograv.online_store.model;

public class Bracelet extends Plate {
    private String strapType;

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


}
