import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== CREATE BANK ACCOUNT =====");

        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter date of birth (DD/MM/YYYY): ");
        String dob = sc.nextLine();

        System.out.print("Enter gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter address: ");
        String address = sc.nextLine();

        System.out.print("Enter initial balance: Rs. ");
        double initialBalance = sc.nextDouble();

        while (initialBalance < 0) {

            System.out.print(
                    "Initial balance cannot be negative. Enter again: Rs. "
            );

            initialBalance = sc.nextDouble();
        }

        BankAccount account = new BankAccount(
                name,
                dob,
                gender,
                address,
                initialBalance
        );

        System.out.println("\nAccount created successfully!");

        int choice;

        do {

            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. View Account Details");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print(
                            "Enter amount to deposit: Rs. "
                    );

                    double depositAmount = sc.nextDouble();

                    account.deposit(depositAmount);

                    break;

                case 2:

                    System.out.print(
                            "Enter amount to withdraw: Rs. "
                    );

                    double withdrawAmount = sc.nextDouble();

                    account.withdraw(withdrawAmount);

                    break;

                case 3:

                    account.displayBalance();

                    break;

                case 4:

                    account.displayAccountDetails();

                    break;

                case 5:

                    account.displayTransactionHistory();

                    break;

                case 6:

                    System.out.println(
                            "Thank you for using the Bank Account Simulator."
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice. Please select between 1 and 6."
                    );
            }

        } while (choice != 6);

        sc.close();
    }
}