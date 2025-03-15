public class Book {
    private String title;
    private String author;
    private int price;

//    Default Constructor
    Book() {
        title = "Default";
        author = "none";
        price = 0;
    }

//    Parameterize Constructor
    Book(String t, String a, int p) {
        title = t;
        author = a;
        price = p;
    }

//    Setters
//    void setTitle(String t) {
//        title = t;
//    }
//    void setAuthor (String a) {
//        author = a;
//    }
    void setPrice(int p) {
        price = p;
    }

//    Getters
//    String getTitle() {
//        return title;
//    }
//    String getAuthor() {
//        return author;
//    }
    int getPrice() {
        return price;
    }

//    Print Details
    void details() {
        System.out.println("Book Title: " + title + ", Author: " + author + ", Price: " + price);
    }
}
