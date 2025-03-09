public class Car {
//    Class Members / Class Instance
    private String brand;
    private int speed;

//    Creating a Default Constructor
    Car () {
        this.speed = 0;
        this.brand = "Default";
    }

//    Creating a parameterize Constructor
    Car(String name, int speed) {
        this.brand = name;
        this.speed = speed;
    }

//    Creating Getters and Setters
    public void setBrand(String name) {
        this.brand = name;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getBrand() {
        return brand;
    }
    public int getSpeed() {
        return speed;
    }

//    Member Function
    void showDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed);
    }
}
