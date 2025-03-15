public class Main {
    public static void main(String[] args) {
        System.out.println("Main Method ...");

        Car car1 = new Car();

        car1.setBrand("BMW");
        car1.setModel("M5");
        car1.setYear(2022);

        System.out.println("\nObject - 1");
//        using get method to display all fields
        System.out.println("Printing the info using \'Get Method\'");
        System.out.println("Brand: " + car1.getBrand() + ", Model: " + car1.getModel() + ", Year: " + car1.getYear());

//        using user-defined method info()
        System.out.println("Printing the info using \'User-Defined Method\'");
        car1.info();

        Car car2 = new Car("Audi", "A6", 2024);
        System.out.println("\nObject - 2");

//        using user-defined method info()
        System.out.println("Printing the info using \'User-Defined Method\'");
        car1.info();
    }
}