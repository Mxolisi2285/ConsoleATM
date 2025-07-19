import java.io.Console;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        // Pre-load some user accounts
        accounts.put("user1", new Account("1234", 1000.0));
        accounts.put("user2", new Account("4321", 500.0));

        System.out.println("Welcome to the ATM!");

        Account currentAccount = authenticate();

        if (currentAccount == null) {
            System.out.println("Too many failed attempts. Exiting...");
            return;
        }

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.printf("Current Balance: R%.2f%n", currentAccount.getBalance());
                    break;
                case "2":
                    withdrawCash(currentAccount);
                    break;
                case "3":
                    depositCash(currentAccount);
                    break;
                case "4":
                    transferFunds(currentAccount);
                    break;
                case "5":
                    changePin(currentAccount);
                    break;
                case "6":
                    currentAccount.printTransactionHistory();
                    break;
                case "7":
                    currentAccount.printMiniStatement();
                    break;
                case "8":
                    createAccount();
                    break;
                case "9":
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Cash");
        System.out.println("3. Deposit Cash");
        System.out.println("4. Transfer Funds");
        System.out.println("5. Change PIN");
        System.out.println("6. View Full Transaction History");
        System.out.println("7. View Mini Statement (Last 5 transactions)");
        System.out.println("8. Create New Account");
        System.out.println("9. Exit");
        System.out.print("Enter choice: ");
    }

    private static Account authenticate() {
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            String pin = readPinInput();

            Account account = accounts.get(username);
            if (account != null && account.validatePin(pin)) {
                System.out.println("Login successful!");
                return account;
            } else {
                System.out.println("Invalid username or PIN.");
                attempts++;
            }
        }
        return null;
    }

    private static String readPinInput() {
        Console console = System.console();
        if (console != null) {
            char[] pinArray = console.readPassword("Enter PIN: ");
            return new String(pinArray);
        } else {
            // fallback for IDEs without a console
            System.out.print("Enter PIN: ");
            return scanner.nextLine();
        }
    }

    private static void withdrawCash(Account account) {
        System.out.print("Enter amount to withdraw: R");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Invalid amount or insufficient funds.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    private static void depositCash(Account account) {
        System.out.print("Enter amount to deposit: R");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            if (amount > 0) {
                account.deposit(amount);
                System.out.println("Deposit successful.");
            } else {
                System.out.println("Amount must be positive.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    private static void transferFunds(Account fromAccount) {
        System.out.print("Enter recipient username: ");
        String recipientUsername = scanner.nextLine();

        Account toAccount = accounts.get(recipientUsername);
        if (toAccount == null) {
            System.out.println("Recipient account does not exist.");
            return;
        }

        System.out.print("Enter amount to transfer: R");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            if (fromAccount.transferTo(toAccount, amount)) {
                System.out.println("Transfer successful.");
            } else {
                System.out.println("Invalid amount or insufficient funds.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    private static void changePin(Account account) {
        System.out.print("Enter current PIN: ");
        String oldPin = scanner.nextLine();

        System.out.print("Enter new 4-digit PIN: ");
        String newPin = scanner.nextLine();

        if (account.changePin(oldPin, newPin)) {
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Failed to change PIN. Make sure the current PIN is correct and the new PIN is 4 digits.");
        }
    }

    private static void createAccount() {
        System.out.print("Enter new username: ");
        String username = scanner.nextLine();

        if (accounts.containsKey(username)) {
            System.out.println("Username already exists!");
            return;
        }

        System.out.print("Enter 4-digit PIN: ");
        String pin = scanner.nextLine();

        if (!pin.matches("\\d{4}")) {
            System.out.println("Invalid PIN format.");
            return;
        }

        System.out.print("Enter initial deposit amount: R");
        double initialDeposit;
        try {
            initialDeposit = Double.parseDouble(scanner.nextLine());
            if (initialDeposit < 0) {
                System.out.println("Initial deposit cannot be negative.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount.");
            return;
        }

        Account newAccount = new Account(pin, initialDeposit);
        accounts.put(username, newAccount);
        System.out.println("Account created successfully!");
    }
}