import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        // Created a TransactionManager to store and handle all transactions
        TransactionManager manager = new TransactionManager();


        //Load existing transaction from file
        manager.readTransactionFromFile("src/main/resources/transactions.csv");


        //Boolean to control when to exit program
        boolean running = true;


        // Main menu loop keeps running until user chooses Exit
        while (running) {

            // Displays the main menu
            System.out.println("--------------------");
            System.out.println("   Home Screen  ");
            System.out.println("---------------------");
            System.out.println("D).Add Deposit");
            System.out.println("P).Make a payment(Debit)");
            System.out.println("L).Ledger");
            System.out.println("E).Exit");
            System.out.println("---------------------");

            System.out.print("Enter your choice (D, P, L, E): ");

            // Switch statement decides what to do based on user input
            String choice = myScanner.nextLine().trim().toUpperCase();


            //Switch statement executes different code based on their choice value
            try {
                switch (choice) {
                    case "D":
                        addDeposit(myScanner, manager);
                        manager.saveTransactionsToFile("src/main/resources/transactions.csv");
                        break;
                    case "P":
                        addPayment(myScanner, manager);
                        manager.saveTransactionsToFile("src/main/resources/transactions.csv");
                        break;
                    case "L":
                        ledger(myScanner, manager);
                        break;
                    case "E":
                        running = false;  // Set exit to true, which will end the while loop
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter D, P, L, or E.\n");
                }
            } catch (Exception e) {
                System.out.println(" Invalid try again! " + e);

            }
        }
        myScanner.close();
    }

    // Methods for the users choice
    private static void addPayment(Scanner myScanner, TransactionManager manager) {
        // Automatically get today's date and time
        LocalDate transactionDate = LocalDate.now();
        LocalTime transactionTime = LocalTime.now();

        System.out.print("Enter description: ");
        String description = myScanner.nextLine();

        System.out.print("Enter the vendor name: ");
        String vendor = myScanner.nextLine();

        System.out.print("Enter Payment amount: ");
        double amount = myScanner.nextDouble(); // Reads payment amount as a Double
        amount = amount * -1;
        myScanner.nextLine();

        // Create a new Transaction and add it to the list
        Transaction transaction = new Transaction(transactionDate, transactionTime, description, vendor, amount);
        manager.addTransaction(transaction);
        System.out.println("Payment added!");
    }

    private static void addDeposit(Scanner myScanner, TransactionManager manager) {
        LocalDate transactionDate = LocalDate.now();
        LocalTime transactionTime = LocalTime.now();

        System.out.print("Enter description: ");
        String description = myScanner.nextLine();

        System.out.print("Enter the vendor name: ");
        String vendor = myScanner.nextLine();

        System.out.print("Enter the deposit amount: ");
        double amount = myScanner.nextDouble();
        myScanner.nextLine();

        Transaction transaction = new Transaction(transactionDate, transactionTime, description, vendor, amount);
        manager.addTransaction(transaction);
        System.out.print("Deposit added!");

    }


    private static void ledger(Scanner myScanner, TransactionManager manager) {
        boolean running = true;

        while (running) {
            System.out.println("--------------------");
            System.out.println("   Ledger Menu    ");
            System.out.println("--------------------");
            System.out.println("A). All ");
            System.out.println("D). Deposits ");
            System.out.println("P). Payments ");
            System.out.println("R). Reports  ");
            System.out.println("H). Home (Back to Home Screen) ");
            System.out.println("--------------------");

            System.out.print("Enter your choice (A, D, P, R, H): ");
            String choice = myScanner.nextLine().trim().toUpperCase();

            try {
                switch (choice) {
                    case "A":
                        displayAllEntries(manager);
                        break;
                    case "D":
                        displayDeposits(manager);
                        break;
                    case "P":
                        displayPayments(manager);
                    case "R":
                        Reports.reportMenu(myScanner, manager);
                        break;
                    case "H":
                        running = false;
                    default:
                        System.out.println("Invalid option. Please try again ");
                        break;
                }
            } catch (Exception e) {
                System.err.println("Invalid try again" + e);
            }
        }
    }
    // Displays all transactions (newest first)
    private static void displayAllEntries(TransactionManager manager) {
        ArrayList<Transaction> transactions = manager.getTransactions();
        for (int i = transactions.size() - 1; i >= 0; i--) {
            System.out.println(transactions.get(i));
        }
    }
    // Displays only deposit entries (positive amounts)
    private static void displayDeposits(TransactionManager manager) {
        ArrayList<Transaction> transactions = manager.getTransactions();
        for (Transaction transaction : transactions) {  //for-each loop
            if (transaction.getAmount() > 0) {
                System.out.println(transaction);
            }
        }
    }
   // Displays only payment entries (negative amounts)
    private static void displayPayments(TransactionManager manager) {
        ArrayList<Transaction> transactions = manager.getTransactions();
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0) {
                System.out.println(transaction);
            }
        }
    }


}


