import java.io.Console;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Account {
    private String pin;
    private double balance;
    private final List<String> transactionHistory;

    public Account(String pin, double initialBalance) {
        this.pin = pin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        addTransaction("Account created with balance", initialBalance);
    }

    public boolean validatePin(String inputPin) {
        return pin.equals(inputPin);
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction("Withdrawal", amount);
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposit", amount);
        }
    }

    public boolean transferTo(Account targetAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            targetAccount.balance += amount;
            addTransaction("Transfer Out", amount);
            targetAccount.addTransaction("Transfer In", amount);
            return true;
        }
        return false;
    }

    public boolean changePin(String oldPin, String newPin) {
        if (this.pin.equals(oldPin) && newPin.matches("\\d{4}")) {
            this.pin = newPin;
            addTransaction("PIN changed", 0);
            return true;
        }
        return false;
    }

    private void addTransaction(String type, double amount) {
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String entry = (amount > 0) ?
                String.format("%s - %s: R%.2f", timestamp, type, amount) :
                String.format("%s - %s", timestamp, type);
        transactionHistory.add(entry);
    }

    public void printTransactionHistory() {
        System.out.println("\n=== Full Transaction History ===");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            transactionHistory.forEach(System.out::println);
        }
        System.out.println("================================");
    }

    public void printMiniStatement() {
        System.out.println("\n=== Mini Statement (Last 5 Transactions) ===");
        int start = Math.max(transactionHistory.size() - 5, 0);
        List<String> lastFive = transactionHistory.subList(start, transactionHistory.size());
        if (lastFive.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            lastFive.forEach(System.out::println);
        }
        System.out.println("=============================================");
    }
}