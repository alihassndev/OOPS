//Practice of Encapsulation using setters and getters

public class Account {
//    Instance variables
    private String name;
    private double balance;

//    Default Constructor
    Account() {
        this.name = "Default";
        this.balance = 0.0;

        System.out.println("This is Default Constructor ...");
    }

//    Parameterize Constructor
    Account(String name, double amount) {
        this.name = name;
        this.balance = amount;

        System.out.println("This is parameterize constructor ...");
    }

//    Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setBalance(double amount) {
        this.balance = amount;
    }

//    Getters
    public void getName() {
        System.out.println("Your name is: " + this.name);
    }
    public void getBalance() {
        System.out.println("Your balance is: " + this.balance);
    }
}