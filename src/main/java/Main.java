import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        boolean exit = false;
        boolean isRunning = true;
        int choice;

//made while loop until a person makes an exit
        while (!exit) {

            System.out.println("--------------------");
            System.out.println("   Home Screen  ");
            System.out.println("---------------------");
            System.out.println("1).Add Deposit");
            System.out.println("2).Make a payment(Debit)");
            System.out.println("3).Ledger");
            System.out.println("4).Exit");
            System.out.println("---------------------");

            System.out.println("Enter your choice 1-4");
            choice = myScanner.nextInt();

            switch (choice) {
                case 1:
                    addDeposit();
                    break;
                case 2:
                    addPayment();
                    break;
                case 3:
                    ledger();
                    break;
                case 4:
                    exit = true;

            }
        }
    }

    private static void ledger() {
    }

    private static void addPayment() {
    }

    private static void addDeposit() {
    }


}
