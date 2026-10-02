import java.util.ArrayList;
import java.util.Random;

public class BankAccount {

    private String accountHolder;
    private String dateOfBirth;
    private String gender;
    private String address;
    private double balance;

    private long accountNumber;

    private ArrayList<String> transactionHistory;

    public BankAccount(String accountHolder, String dateOfBirth,
                       String gender, String address, double balance) {

        this.accountHolder = accountHolder;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.balance = balance;

        Random random = new Random();

        this.accountNumber = 1000000000L
                + (long) (random.nextDouble() * 9000000000L);

        transactionHistory = new ArrayList<>();

        transactionHistory.add(
                "Account created with balance Rs. " + balance
        );
    }

    public void deposit(double amount) {

        if (amount > 0) {

            balance = balance + amount;

            transactionHistory.add(
                    "Deposited Rs. " + amount
            );

            System.out.println("Deposit successful.");

        } else {

            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {

        if (amount <= 0) {

            System.out.println("Invalid withdrawal amount.");

        } else if (amount > balance) {

            System.out.println("Insufficient balance.");

        } else {

            balance = balance - amount;

            transactionHistory.add(
                    "Withdrawn Rs. " + amount
            );

            System.out.println("Withdrawal successful.");
        }
    }

    public void displayBalance() {

        System.out.println(
                "Current Balance: Rs. " + balance
        );
    }

    public void displayAccountDetails() {

        System.out.println("\n===== ACCOUNT DETAILS =====");

        System.out.println(
                "Account Number : " + accountNumber
        );

        System.out.println(
                "Account Holder : " + accountHolder
        );

        System.out.println(
                "Date of Birth  : " + dateOfBirth
        );

        System.out.println(
                "Gender         : " + gender
        );

        System.out.println(
                "Address        : " + address
        );

        System.out.println(
                "Balance        : Rs. " + balance
        );

        System.out.println("===========================");
    }

    public void displayTransactionHistory() {

        System.out.println("\n===== TRANSACTION HISTORY =====");

        if (transactionHistory.isEmpty()) {

            System.out.println("No transactions found.");

        } else {

            for (int i = 0; i < transactionHistory.size(); i++) {

                System.out.println(
                        (i + 1) + ". " + transactionHistory.get(i)
                );
            }
        }

        System.out.println("===============================");
    }
}