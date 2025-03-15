public class BankAccount {
    private double balance;

    BankAccount() {
        balance = 0.0;
    }

//    Setter
    void setBalance(Double b) {
        balance = b;
    }

//    Getter
    double getBalance() {
        return balance;
    }

//    Show balance
    private void showBalanace() {
        System.out.println("Your balance: " + balance);
    }

//    Deposit money
    void deposit(double amount) {
        if (amount > 0) {
        balance += amount;
        showBalanace();
        } else {
            System.out.println("Enter a Valid Amount greater than Zero !");
        }
    }

    void withDrawMoney(double m) {
        if (m < balance) {
        balance -= m;
        showBalanace();
        } else  {
            System.out.println("Enter a Valid Amount less than : " + balance);
        }
    }
}
