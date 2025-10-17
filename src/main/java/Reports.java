import java.time.LocalDate;
import java.util.Scanner;

public class Reports {

    // This method displays the Reports menu and handles the user's choice
    public static void reportMenu(Scanner myScanner, TransactionManager manager) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("-------------------");
            System.out.println("    Report Menu  ");
            System.out.println("-------------------");
            System.out.println("1). Month To Date");
            System.out.println("2). Previous Month");
            System.out.println("3). Year To Date ");
            System.out.println("4). Previous Year ");
            System.out.println("5). Search By Vendor");
            System.out.println("0). Back (Back to Ledger Menu)");

            System.out.print("Enter Your Choice: (1,2,3,4,5,0): ");
            String choice = myScanner.nextLine().trim().toUpperCase();

            // Switch handles the user's menu selection
            try {
                switch (choice) {
                    case "1":
                        monthToDateReport(manager);
                        break;
                    case "2":
                        previousMonthReport(manager);
                        break;
                    case "3":
                        yearToDateReport(manager);
                        break;
                    case "4":
                        previousYearReport(manager);
                        break;
                    case "5":
                        searchByVendor(myScanner, manager);
                        break;
                    case "0":
                        isRunning = false;  //Go back to ledger menu
                    default:
                        System.out.println("Invalid Option Please Try Again!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid try again" + e);
            }
        }


    }

    private static void monthToDateReport(TransactionManager manager) {
        //  ArrayList<Transaction> allTransactions = manager.getTransactions();
        LocalDate today = LocalDate.now();                 //Today's date
        LocalDate startOfMonth = today.withDayOfMonth(1); //First day of the month

        System.out.println("\n_______________________");
        System.out.println("Month To Date Report ");
        System.out.println("_________________________");

        double total = 0; // Variable keeps track of total amount

        // Loop through each transaction
        for (Transaction t : manager.getTransactions()) {
            LocalDate date = t.getDate();

            // Include transactions from start of month up to today
            if (!date.isBefore(startOfMonth) && !date.isAfter(today)) {
                System.out.println(t);
                total += t.getAmount();   // Add each amount to total

            }
        }
        System.out.println("total for this month: $" + total);


    }

    private static void previousMonthReport(TransactionManager manager) {
        LocalDate today = LocalDate.now();
        LocalDate previousMonth = LocalDate.now().minusMonths(1); // Go one month back

        System.out.println("\n_______________________");
        System.out.println("Previous Month Report");
        System.out.println("_________________________");

        // Getting the first and last day of the previous month
        LocalDate startOfPrevMonth = previousMonth.withDayOfMonth(1);
        LocalDate endOfPrevMonth = previousMonth.withDayOfMonth(previousMonth.lengthOfMonth());


        double total = 0;

        for (Transaction t : manager.getTransactions()) {
            LocalDate date = t.getDate();

            // Include only transactions from that previous month
            if (!date.isBefore(startOfPrevMonth) && !date.isAfter(endOfPrevMonth)) {
                System.out.println(t);
                total += t.getAmount();
            }
        }
        System.out.println("Total for previous month: $" + total);

    }

    private static void yearToDateReport(TransactionManager manager) {
        LocalDate today = LocalDate.now();
        LocalDate startOfYear = LocalDate.of(today.getYear(), 1, 1);

        System.out.println("\n_______________________");
        System.out.println("Year To Date Report ");
        System.out.println("_________________________");

        double total = 0;

        for (Transaction t : manager.getTransactions()) {
            LocalDate date = t.getDate();

            // Include everything from start of year up to today
            if (!date.isBefore(startOfYear) && !date.isAfter(today)) {
                System.out.println(t);
                total += t.getAmount();

            }
        }
        System.out.printf("Total for Year:  $%.2f\n", total);
    }

    private static void previousYearReport(TransactionManager manager) {
        LocalDate today = LocalDate.now();
        int previousYear = today.getYear() - 1;  //one year before this year

        System.out.println("\n_______________________");
        System.out.println("Previous Year Report ");
        System.out.println("_________________________");

        LocalDate startOfPrevYear = LocalDate.of(previousYear, 1, 1); // Jan 1 of last year
        LocalDate endOfPrevYear = LocalDate.of(previousYear, 12, 31); // Dec 31 of last year

        double total = 0;

        for (Transaction t : manager.getTransactions()) {
            LocalDate date = t.getDate();

            // Include only transactions from last year
            if (!date.isBefore(startOfPrevYear) && !date.isAfter(endOfPrevYear)) {
                System.out.println(t);
                total += t.getAmount();
            }
        }
        System.out.printf("Total of Last Year:  $%.2f\n", total);

    }

    private static void searchByVendor(Scanner myScanner, TransactionManager manager) {
        System.out.println("Enter vendor name: ");
        String vendor = myScanner.nextLine().trim();

        boolean found = false;
        double total = 0;

        // Loop through all transactions and find matches
        for (Transaction t : manager.getTransactions()) {
            if (t.getVendor().equalsIgnoreCase(vendor)) {
                System.out.println(t);
                total += t.getAmount();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No transactions found for vendor " + vendor);
        } else {
            System.out.printf("Total spent at %s: $%.2f\n", vendor, total);

        }
    }
}
