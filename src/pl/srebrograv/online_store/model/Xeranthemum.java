package pl.srebrograv.online_store.model;

public class Xeranthemum extends Plate {
    private String engravingMessage;

    public Xeranthemum(String pendantName, String metalType, String engravingMessage) {
        super(pendantName, metalType);
        this.engravingMessage = engravingMessage;
    }

    public String getEngravingMessage() {
        return engravingMessage;
    }

    public void setEngravingMessage(String engravingMessage) {
        this.engravingMessage = engravingMessage;
    }
}
