public class CellPhone extends Product{
    private String brand;
    private String model;
    private int cameraQuality;
    private String processor;
    private int ram;
    private int storage;
    private String OS;
    private double screenSize;
    private String color;
    public CellPhone(String name, double price, int quantity, String category, String brand, String model, String processor, int cameraQuality, int ram, int storage, String OS, double screenSize, String color)
    {
        super(name, price, quantity, category);
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.cameraQuality = cameraQuality;
        this.ram = ram;
        this.storage = storage;
        this.OS = OS;
        this.screenSize = screenSize;
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

    public int getCameraQuality() {
        return cameraQuality;
    }

    public void setCameraQuality(int cameraQuality) {
        this.cameraQuality = cameraQuality;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
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

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + "->" + "CellPhone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", cameraQuality=" + cameraQuality +
                ", processor='" + processor + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", OS='" + OS + '\'' +
                ", screenSize=" + screenSize +
                ", color='" + color + '\'' +
                '}';
    }
}
