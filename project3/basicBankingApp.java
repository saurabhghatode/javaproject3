import java.util.Scanner;

class BankAccount {
    private String accountHolder; // Name of the account holder
    private double balance; // Current balance in the account

    // Constructor to initialize the bank account
    public BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.balance = 0.0; // Start with an empty account
    }

    // Method to handle deposits
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("\nGreat! You've deposited " + amount + ".");
            System.out.println("Your updated balance is " + balance + ".");
        } else {
            System.out.println("\nOops! That deposit amount doesn't look valid. Try again!");
        }
    }

    // Method to handle withdrawals
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("\nYou just withdrew " + amount + ". Be wise with your spending!");
            System.out.println("Remaining balance: " + balance + ".");
        } else {
            System.out.println("\nHmm, you either don't have enough funds or entered an invalid amount.");
        }
    }

    // Method to display the current balance
    public void checkBalance() {
        System.out.println("\nAccount Summary for " + accountHolder + ":");
        System.out.println("Current Balance: " + balance);
    }
}

public class basicBankingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to your friendly banking assistant! 🏦");
        System.out.print("What's your name? ");
        String name = scanner.nextLine();

        // Creating a new account
        BankAccount account = new BankAccount(name);
        System.out.println("\nHi " + name + "! Your account has been created successfully.");

        int choice;
        do {
            // Main menu with options
            System.out.println("\nWhat would you like to do today?");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Account Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("\nHow much would you like to deposit? ₹");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("\nHow much would you like to withdraw? ₹");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    System.out.println("\nThanks for banking with us, " + name + "! Have a great day! 👋");
                    break;

                default:
                    System.out.println("\nThat doesn't seem to be a valid option. Please choose again!");
            }
        } while (choice != 4);

        scanner.close(); // Close the scanner to free resources
    }
}