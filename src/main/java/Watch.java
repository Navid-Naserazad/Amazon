public class Watch extends Product {
    private String brand;
    private String model;
    private boolean isSmart;
    private String OS;
    private double screenSize;
    private String processor;
    private int storage;

    public Watch(String name, double price, int quantity, String category, String brand, String model, boolean isSmart, String OS, double screenSize, String processor, int storage) {
        super(name, price, quantity, category);
        this.brand = brand;
        this.model = model;
        this.isSmart = isSmart;
        this.OS = OS;
        this.screenSize = screenSize;
        this.processor = processor;
        this.storage = storage;
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

    public boolean getIsSmart() {
        return isSmart;
    }

    public void setIsSmart(boolean isSmart) {
        this.isSmart = isSmart;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return super.toString() + "->" + "Watch{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", isSmart=" + isSmart +
                ", OS='" + OS + '\'' +
                ", screenSize=" + screenSize +
                ", processor='" + processor + '\'' +
                ", storage=" + storage +
                '}';
    }
}
