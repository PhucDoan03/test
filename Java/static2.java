import java.util.Scanner;

class BankAccount {
    // Static variables
    private static int totalAccounts = 0;
    private static double bankBalance = 0.0;

    // Instance variables
    private int accountID;
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        totalAccounts++;
        this.accountID = totalAccounts;
        this.balance = initialBalance;
        bankBalance += initialBalance;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static double getTotalBankBalance() {
        return bankBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            bankBalance += amount;
            System.out.println("Deposited " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            bankBalance -= amount;
            System.out.println("Withdrew " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public void displayAccountInfo() {
        System.out.println("Account ID: " + accountID);
        System.out.println("Current Balance: " + balance);
    }
}

public class static2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter initial balance for the 1st account: ");
        double initialBalance1 = sc.nextDouble();
        BankAccount account1 = new BankAccount(initialBalance1);

        System.out.println("Enter initial balance for the 2nd account: ");
        double initialBalance2 = sc.nextDouble();
        BankAccount account2 = new BankAccount(initialBalance2);

        // Show accounts details
        System.out.println("\nAccount 1 Info: ");
        account1.displayAccountInfo();

        System.out.println("\nAccount 2 Info: ");
        account2.displayAccountInfo();

        // Deposit and withdraw
        System.out.println("\nEnter deposit amount for Account 1: ");
        double depositAmount1 = sc.nextDouble();
        account1.deposit(depositAmount1);

        System.out.println("Enter withdrawal amount for Account 1: ");
        double withdrawAmount1 = sc.nextDouble();
        account1.withdraw(withdrawAmount1);

        // Use static methods to get general data of the bank
        System.out.println("\nTotal number of accounts: " + BankAccount.getTotalAccounts());
        System.out.println("Total bank balance: " + BankAccount.getTotalBankBalance());

        sc.close();
    }
}
