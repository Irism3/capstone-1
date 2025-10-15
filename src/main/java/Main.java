import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        boolean exit = false;
        boolean isRunning = true;  //keeps program running until user exits
        int choice;
        Double deposit;


        //made while loop until a person makes an exit
        while (!exit) {
            //Home Screen
            System.out.println("--------------------");
            System.out.println("   Home Screen  ");
            System.out.println("---------------------");
            System.out.println("1).Add Deposit");
            System.out.println("2).Make a payment(Debit)");
            System.out.println("3).Ledger");
            System.out.println("4).Exit");
            System.out.println("---------------------");

            System.out.print("Enter your choice 1-4: ");
            choice = myScanner.nextInt();

            switch (choice) {
                case 1:
                    addDeposit(myScanner);
                    break;
                case 2:
                    addPayment(myScanner);
                    break;
                case 3:
                    ledger();
                    break;
                case 4:
                    exit = true;

            }
        }
    }
//Methods for each operation
    private static void ledger() {

    }

    private static void addPayment(Scanner myScanner) {
        System.out.println("Enter Payment: ");
        Double payment = myScanner.nextDouble();
        System.out.println("Payment added!");
    }

    private static void addDeposit(Scanner myScanner) {
        System.out.println("Enter your deposit: ");
        Double deposit = myScanner.nextDouble();
        System.out.println("Deposit added!");

    }


}
