import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Main Method ...");

//        Creating an object
        BankAccount account1 = new BankAccount();
        int amount = 0, choice = 0;

        do {
        System.out.print("Enter Choice \n1 -> deposit Or 2 -> withdraw Or Any key -> exit: ");
        choice = sc.nextInt();

        if (choice == 1) {
            System.out.print("Enter Your Deposit Amount: ");
            amount = sc.nextInt();
            account1.deposit(amount);
        } else if (choice == 2) {
            System.out.print("Enter Your WithDraw Amount: ");
            amount = sc.nextInt();
            account1.withDrawMoney(amount);
        } else {
            break;
        }

        } while (choice != 0);

    }
}