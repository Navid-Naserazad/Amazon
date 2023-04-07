public class Laptop extends Product {
    private String brand;
    private String model;
    private String processor;
    private double screenSize;
    private int ram;
    private String CPU;
    private int storage;
    private String OS;

    public Laptop(String name, double price, int quantity, String category, String brand, String model, String processor, double screenSize, int ram, String CPU, int storage, String OS)
    {
        super(name, price, quantity, category);
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.screenSize = screenSize;
        this.ram = ram;
        this.CPU = CPU;
        this.storage = storage;
        this.OS = OS;
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

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenQuality) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    @Override
    public String toString() {
        return super.toString() + "->" + "Laptop{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", processor='" + processor + '\'' +
                ", screenSize='" + screenSize + '\'' +
                ", ram=" + ram +
                ", CPU='" + CPU + '\'' +
                ", storage=" + storage +
                ", OS='" + OS + '\'' +
                '}';
    }
}
