import java.util.Scanner;

public class ATM {
    private static double balance = 1000.00; // Initial balance
    private static final String USER_PIN = "1234"; // Dummy PIN

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Simple ATM!");
        System.out.print("Please enter your PIN: ");
        String enteredPin = scanner.nextLine();

        if (!enteredPin.equals(USER_PIN)) {
            System.out.println("Incorrect PIN. Exiting.");
            return;
        }

        int option;

        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    viewBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1 to 4.");
            }

        } while (option != 4);

        scanner.close();
    }

    public static void viewBalance() {
        System.out.printf("Your current balance is: $%.2f\n", balance);
    }

    public static void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount. Must be greater than zero.");
        } else {
            balance += amount;
            System.out.printf("Successfully deposited $%.2f\n", amount);
        }
    }

    public static void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount. Must be greater than zero.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.printf("Successfully withdrew $%.2f\n", amount);
        }
    }
}
