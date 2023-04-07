public class Television extends Product {
    private String brand;
    private String model;
    private int screenSize;
    private boolean isSmart;
    public Television(String name, double price, int quantity, String category, String  brand, String model, int screenSize, boolean isSmart)
    {
        super(name, price, quantity, category);
        this.brand = brand;
        this.model = model;
        this.screenSize = screenSize;
        this.isSmart = isSmart;
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

    public int getScreenSize() {
        return screenSize;
    }

    public void setSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public boolean getIsSmart() {
        return isSmart;
    }

    public void setIsSmart(boolean isSmart) {
        this.isSmart = isSmart;
    }

    @Override
    public String toString() {
        return super.toString() + "->" + "Television{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", screenSize=" + screenSize +
                ", isSmart=" + isSmart +
                '}';
    }
}
