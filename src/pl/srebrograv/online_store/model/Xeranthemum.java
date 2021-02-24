package pl.srebrograv.online_store.model;

public class Xeranthemum extends Plate implements CsvConvertible {
    private String engravingMessage;
    public static final String TYPE = "Xeranthemum";

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

    @Override
    public String toCsv() {
        return (TYPE + ";") +
                getPendantName() + ";" +
                getMetalType() + ";" +
                getEngravingMessage();
    }
}
