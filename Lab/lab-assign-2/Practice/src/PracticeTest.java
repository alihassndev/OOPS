class BankAccount {
    String holder="";
    int balance=0;

    BankAccount(String holder, int balance) {
        this.holder = holder;
        this.balance = balance;
    }

    void deposit(int amount) {
        this.balance += amount;
    }

    void transfer(BankAccount target, int amount) {
        this.balance -= amount;
        target.balance += amount;
        target = this;
        target.balance += 500;
    }

    void swap(BankAccount other) {
        String tempHolder = this.holder;
        this.holder = other.holder;
        other.holder = tempHolder;

        int tempBalance = this.balance;
        this.balance = other.balance;
        other.balance = tempBalance;
    }

    void rename(String newName) {
        holder = newName;
    }
}

public class PracticeTest {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Alice", 5000);
        BankAccount acc2 = new BankAccount("Bob", 3000);

        acc1.transfer(acc2, 1000);
        acc2.rename("Charlie");
        acc1.swap(acc2);
        acc2.deposit(200);

        System.out.println(acc1.holder + " " + acc1.balance);
        System.out.println(acc2.holder + " " + acc2.balance);
    }
}