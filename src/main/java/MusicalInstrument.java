public class MusicalInstrument extends Product{
    private String InstrumentName;
    private String brand;
    private String model;
    private String color;

    public MusicalInstrument(String name, double price, int quantity, String category, String InstrumentName, String brand, String model, String color)
    {
        super(name, price, quantity, category);
        this.InstrumentName = InstrumentName;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public String getInstrumentName() {
        return InstrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        InstrumentName = instrumentName;
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + "->" + "MusicalInstrument{" +
                "InstrumentName='" + InstrumentName + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
