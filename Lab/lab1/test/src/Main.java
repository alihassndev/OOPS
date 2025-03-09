public class Main {
    public static void main(String [] args) {
        System.out.println("This is main");

//        Using Default Constructor
        Account myaccount1 = new Account();
        myaccount1.getName();
        myaccount1.getBalance();

//        Using Parameterize Constructor
        Account myaccount2 = new Account("Ali", 100000.0);
        myaccount2.getName();
        myaccount2.getBalance();
    }
}