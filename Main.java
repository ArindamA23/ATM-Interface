//Here it is a simple Java code to make a ATM interface  this code is too long to live record 
import java.util.Scanner;
class BankAccount {//Bank account is a class to represent the user's banl account 
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {//deposit function
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    public void withdraw(double amount) {//withdraw function
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Withdrawal amount must be positive!");
        }
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {//here is the ATM class
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {//here is the key words of ATM interfaces which will be shown to the users
        System.out.println("ATM Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processTransaction(int choice, double amount) {
        switch (choice) {
            case 1:
                account.deposit(amount);
                break;
            case 2:
                account.withdraw(amount);
                break;
            case 3:
                System.out.println("Current balance: " + account.checkBalance());
                break;
            case 4:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid option selected.");
        }
    }
}


public class Main {//hereis the two classes are connected one is MAIN and another is ATM
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(0.0); //here initial balance is initialized while if a user select the withdraw option then the money will be diducted from the value 1000
        //otherwise we can fised the initial value into 0 then the initial value will be 0 and after deposit the user can withdrawal.
        ATM atm = new ATM(account);
        
        int choice;
        double amount;

        do {
            atm.displayMenu();
            System.out.print("Choose an option (1-4): ");
            choice = scanner.nextInt();

            if (choice == 1 || choice == 2) {
                System.out.print("Enter amount: ");
                amount = scanner.nextDouble();
            } else {
                amount = 0; 
            }

            atm.processTransaction(choice, amount);
        } while (choice != 4);

        scanner.close();
    }
}
