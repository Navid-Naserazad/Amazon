public class Camera extends Product{
    private String brand;
    private String model;
    private int cameraQualutity;
    private int opticalZoom;
    private String color;
    private String dimensions;
    private double weight;
    private int videoCaptureResolution;
    public Camera(String name, double price, int quantity, String category, String brand, String model, int cameraQualutity, int opticalZoom, String color, String dimensions, double weight, int videoCaptureResolution)
    {
        super(name, price, quantity, category);
        this.brand = brand;
        this.model = model;
        this.cameraQualutity = cameraQualutity;
        this.opticalZoom = opticalZoom;
        this.color = color;
        this.dimensions = dimensions;
        this.weight = weight;
        this.videoCaptureResolution = videoCaptureResolution;
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

    public int getCameraQualutity() {
        return cameraQualutity;
    }

    public void setCameraQualutity(int cameraQualutity) {
        this.cameraQualutity = cameraQualutity;
    }

    public int getOpticalZoom() {
        return opticalZoom;
    }

    public void setOpticalZoom(int opticalZoom) {
        this.opticalZoom = opticalZoom;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getVideoCaptureResolution() {
        return videoCaptureResolution;
    }

    public void setVideoCaptureResolution(int videoCaptureResolution) {
        this.videoCaptureResolution = videoCaptureResolution;
    }

    @Override
    public String toString() {
        return super.toString() + "->" + "Camera{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", cameraQualutity=" + cameraQualutity +
                ", opticalZoom=" + opticalZoom +
                ", color='" + color + '\'' +
                ", dimensions='" + dimensions + '\'' +
                ", weight=" + weight +
                ", videoCaptureResolution=" + videoCaptureResolution +
                '}';
    }
}