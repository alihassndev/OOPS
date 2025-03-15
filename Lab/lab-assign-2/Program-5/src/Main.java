public class Main {
    public static void main(String[] args) {
        System.out.println("Main Method ...");

//        Creating an object
        Book book1 = new Book();
        System.out.println("Before initializing !");
        book1.details();
        book1 = new Book("Atomic Habits", "James Clear", 1200);
        System.out.println("After initializing !");
        book1.details();

        book1.setPrice(1500);
        System.out.println("After updating the price of book !");
        book1.details();
    }
}