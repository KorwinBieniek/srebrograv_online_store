package pl.srebrograv.online_store.model;

public class Plate {
    private String pendantName;
    private String metalType;

    public Plate(String pendantName, String metalType) {
        this.pendantName = pendantName;
        this.metalType = metalType;
    }

    public String getPendantName() {
        return pendantName;
    }

    public void setPendantName(String pendantName) {
        this.pendantName = pendantName;
    }

    public String getMetalType() {
        return metalType;
    }

    public void setMetalType(String metalType) {
        this.metalType = metalType;
    }

    @Override
    public String toString() {
        return pendantName + ", type of metal: " + metalType;
    }
}
