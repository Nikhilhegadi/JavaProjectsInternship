package bankApplication;

import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountHolder;
    private int accountNumber;
    private double balance;

    public Account(String name, int number) {
        this.accountHolder = name;
        this.accountNumber = number;
        this.balance = 0.0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0)
            this.balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public void displayInfo() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}

public class bankApplication {
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static int nextAccountNumber = 1001;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Simple Banking Application ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number between 1-5: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    System.out.println("Thank you for using the banking application!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1-5.");
            }

        } while (choice != 5);
    }

    private static void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        Account newAccount = new Account(name, nextAccountNumber++);
        accounts.add(newAccount);

        System.out.println("Account created successfully!");
        System.out.println("Account Number: " + newAccount.getAccountNumber());
    }

    private static Account findAccount(int number) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == number) {
                return acc;
            }
        }
        return null;
    }

    private static void depositMoney() {
        System.out.print("Enter account number: ");
        int accNum = scanner.nextInt();
        Account acc = findAccount(accNum);

        if (acc != null) {
            System.out.print("Enter amount to deposit: ₹");
            double amount = scanner.nextDouble();
            if (amount <= 0) {
                System.out.println("Deposit amount must be positive.");
            } else {
                acc.deposit(amount);
                System.out.println("Amount deposited successfully.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdrawMoney() {
        System.out.print("Enter account number: ");
        int accNum = scanner.nextInt();
        Account acc = findAccount(accNum);

        if (acc != null) {
            System.out.print("Enter amount to withdraw: ₹");
            double amount = scanner.nextDouble();
            if (acc.withdraw(amount)) {
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Insufficient balance or invalid amount.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void checkBalance() {
        System.out.print("Enter account number: ");
        int accNum = scanner.nextInt();
        Account acc = findAccount(accNum);

        if (acc != null) {
            acc.displayInfo();
        } else {
            System.out.println("Account not found.");
        }
    }
}
