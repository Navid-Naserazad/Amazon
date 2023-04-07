public class Car extends Product {
    private String brand;
    private String model;
    private int horsepower;
    private String color;
    private String fuelType;
    private double tankVolume;
    private String prodDate;
    public Car(String name, double price, int quantity, String category, String brand, String model, int horsepower, String color, String fuelType, double tankVolume, String prodDate)
    {
        super(name, price, quantity, category);
        this.brand = brand;
        this.model = model;
        this.horsepower = horsepower;
        this.color = color;
        this.fuelType = fuelType;
        this.tankVolume = tankVolume;
        this.prodDate = prodDate;
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

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getTankVolume() {
        return tankVolume;
    }

    public void setTankVolume(double tankVolume) {
        this.tankVolume = tankVolume;
    }

    public String getProdDate() {
        return prodDate;
    }

    public void setProdDate(String prodDate) {
        this.prodDate = prodDate;
    }

    @Override
    public String toString() {
        return super.toString() + "->" + "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", horsepower=" + horsepower +
                ", color='" + color + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", tankVolume=" + tankVolume +
                ", prodDate=" + prodDate +
                '}';
    }
}