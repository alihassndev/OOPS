class Car {
    private String brand;
    private String model;
    private int year;

    Car() {
        this.brand = "";
        this.model = "";
        this.year = 0;
    }

    Car(String b, String m, int y) {
        brand = b;
        model = m;
        year = y;
    }

    //    Setters
    void setBrand(String b) {
        brand = b;
    }
    void setModel(String m) {
        model = m;
    }
    void setYear(int y) {
        year = y;
    }

    //    Getters
    String getBrand() {
        return brand;
    }
    String getModel() {
        return model;
    }
    int getYear() {
        return year;
    }

    //    Display info
    void info() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Year: " + year);
    }
}