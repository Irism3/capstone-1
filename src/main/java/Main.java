import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        TransactionManager manager = new TransactionManager();


        //Load existing transaction from file
        manager.readTransactionFromFile("src/main/resources/transactions.csv");


        //Boolean to control when to exit program..
        boolean exit = false;
        // boolean isRunning = true;  //keeps program running until user exits maybe?

        // Variable to store user's menu choice..
        //int choice;
        // Double deposit; maybe?


        // Loop continues until user chooses to exit
        while (!exit) {  // The '!' means NOT, so this reads "while exit is NOT true"..

            // Displays the main menu
            System.out.println("--------------------");
            System.out.println("   Home Screen  ");
            System.out.println("---------------------");
            System.out.println("D).Add Deposit");
            System.out.println("P).Make a payment(Debit)");
            System.out.println("L).Ledger");
            System.out.println("E).Exit");
            System.out.println("---------------------");

            // Prompt the user for their choice
            System.out.print("Enter your choice D, P, L, E: ");

            // Variable to store user's menu choice..
            String choice = myScanner.nextLine().trim().toUpperCase(); //Reads letter input

            //Reads the integer input from user..
           // choice = myScanner.nextLine();

            //Switch statement executes different code based on their choice value
            try {
                switch (choice) {
                    case "D": //If user enters 1
                        addDeposit(myScanner, manager); // Call addDeposit method
                        manager.saveTransactionsToFile("src/main/resources/transaction.csv");
                        break; //Exit the switch statement
                    case "P": // If user enters 2
                        addPayment(myScanner, manager); // Call addPayment method
                        manager.saveTransactionsToFile("src/main/resources/transaction.csv");
                        break; //Exit the switch statement
                    case "L": //if user enters 3
                        ledger(myScanner, manager); // Call the ledger method
                        break;  //Exit the switch statement
                    case "E":  // If user enters 4
                        exit = true;  // Set exit to true, which will end the while loop
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter D, P, L, or E.\n");
                }
            } catch (Exception e) {
                System.out.println(" Invalid try again! " + e);
                throw new RuntimeException(e);
            }
        }
        myScanner.close();
    }

    private static void addPayment(Scanner myScanner, TransactionManager manager) {
        //myScanner.nextLine();
        System.out.print("Enter the date (yyyy-MM-dd):  ");

        String dateInput = myScanner.nextLine();
        LocalDate transactionDate = LocalDate.parse(dateInput);

        System.out.print("Enter the time (H:mm:ss): ");
        String timeInput = myScanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[H:mm[:ss]]");
        LocalTime transactionTime = LocalTime.parse(timeInput, formatter);

        System.out.print("Enter description: ");
        String description = myScanner.nextLine();

        System.out.print("Enter the vendor name: ");
        String vendor = myScanner.nextLine();

        System.out.println("Enter Payment amount: ");
        double amount = myScanner.nextDouble(); // Reads payment amount as a Double
        amount = amount * -1;
        myScanner.nextLine();

        // save payment value to the file or array
        Transaction transaction = new Transaction(transactionDate, transactionTime, description, vendor, amount);
        manager.addTransaction(transaction);
        System.out.println("Payment added!");
    }

    private static void addDeposit(Scanner myScanner, TransactionManager manager) {

        System.out.print("Enter the date (yyyy-MM-dd):  ");
        String dateInput = myScanner.nextLine();
        LocalDate transactionDate = LocalDate.parse(dateInput);

        System.out.print("Enter the time (H:mm:ss): ");
        String timeInput = myScanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[H:mm[:ss]]");
        LocalTime transactionTime = LocalTime.parse(timeInput, formatter);

        System.out.print("Enter description: ");
        String description = myScanner.nextLine();

        System.out.print("Enter the vendor name: ");
        String vendor = myScanner.nextLine();

        System.out.print("Enter the deposit amount: ");
        double amount = myScanner.nextDouble();
        myScanner.nextLine(); //leftover newline

        // save payment value to the file
        Transaction transaction = new Transaction(transactionDate, transactionTime, description, vendor, amount);
        manager.addTransaction(transaction);
        System.out.print("Deposit added!\n");

    }

    //Add code to display all transactions history
    //Methods for each operation
    //im Re-declaring the scanner
    private static void ledger(Scanner myScanner, TransactionManager manager) {
        System.out.println("**************");
        //System.out.println();


    }


}


