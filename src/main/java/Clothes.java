public class Clothes extends Product {
    private String brand;
    private String gender;
    private String ageRange;
    private String clothesType;
    private String size;
    private String color;
    public Clothes(String name, double price, int quantity, String category, String brand, String gender, String ageRange, String clothesType, String size, String color)
    {
        super(name, price, quantity, category);
        this.brand = brand;
        this.gender = gender;
        this.ageRange = ageRange;
        this.clothesType = clothesType;
        this.size = size;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getClothesType() {
        return clothesType;
    }

    public void setClothesType(String clothesType) {
        this.clothesType = clothesType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString() + "->" + "Clothes{" +
                "brand='" + brand + '\'' +
                ", gender='" + gender + '\'' +
                ", ageRange='" + ageRange + '\'' +
                ", clothesType='" + clothesType + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}