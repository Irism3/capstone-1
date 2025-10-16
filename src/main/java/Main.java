import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        TransactionManager manager = new TransactionManager();


        manager.readTransactionFromFile("src/main/resources/transactions.csv");


        //Boolean to control when to exit program..
        boolean exit = false;
        // boolean isRunning = true;  //keeps program running until user exits maybe?

        // Variable to store user's menu choice..
        int choice;
        // Double deposit; maybe?


        // Loop continues until user chooses to exit
        while (!exit) {  // The '!' means NOT, so this reads "while exit is NOT true"..

            // Displays the main menu
            System.out.println("--------------------");
            System.out.println("   Home Screen  ");
            System.out.println("---------------------");
            System.out.println("1).Add Deposit");
            System.out.println("2).Make a payment(Debit)");
            System.out.println("3).Ledger");
            System.out.println("4).Exit");
            System.out.println("---------------------");

            // Prompt the user for their choice
            System.out.print("Enter your choice 1-4: ");

            //Reads the integer input from user..
            choice = myScanner.nextInt();

            //Switch statement executes different code based on their choice value
            try {
                switch (choice) {
                    case 1: //If user enters 1
                        addDeposit(myScanner); // Call addDeposit method
                        manager.saveTransactionsToFile("src/main/resources/Transaction.csv");
                        break; //Exit the switch statement
                    case 2: // If user enters 2
                        addPayment(myScanner); // Call addPayment method
                        break; //Exit the switch statement
                    case 3: //if user enters 3
                        ledger(); // Call the ledger method
                        break;  //Exit the switch statement
                    case 4:  // If user enters 4
                        exit = true;  // Set exit to true, which will end the while loop
                        break;
                }
            } catch (Exception e) {
                System.out.println(" Invalid try again! " + e);
                throw new RuntimeException(e);
            }
        }
        myScanner.close();
        }

        //Methods for each operation
        //im Re-declaring the scanner
        private static void ledger () {
            //Add code to display all transactions history
        }

        private static void addPayment (Scanner myScanner){
            System.out.println();
            System.out.println("Enter Payment: ");
            Double payment = myScanner.nextDouble(); // Reads payment amount as a Double
            System.out.println("Payment added!");
            // save payment value to the file or array
        }

        private static void addDeposit (Scanner myScanner){
            myScanner.nextLine();
            System.out.print("Enter the date (yyyy-MM-dd):  ");
            String dateInput = myScanner.nextLine();
            LocalDate transactionDate = LocalDate.parse(dateInput);

            System.out.print("Enter the time (HH:mm:ss): ");
            String timeInput = myScanner.nextLine();
            LocalTime transactionTime = LocalTime.parse(timeInput);


            System.out.print("Enter description: ");
            String description = myScanner.nextLine();

            System.out.print("Enter the vendor name: ");
            String vendor = myScanner.nextLine();

            System.out.print("Enter the deposit amount: ");
            double amount = myScanner.nextDouble();

            System.out.print("Transaction added!");
            // save payment value to the file

            Transaction transaction = new Transaction(transactionDate, transactionTime, description, vendor, amount);


        }



}
