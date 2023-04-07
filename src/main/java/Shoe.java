public class Shoe extends Product{
    private String brand;
    private String model;
    private int size;
    private String color;

    public Shoe(String name, double price, int quantity, String category, String brand, String  model, int size, String color)
    {
        super(name, price, quantity, category);
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.color = color;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + "->" + "Shoe{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", size=" + size +
                ", color='" + color + '\'' +
                '}';
    }
}
