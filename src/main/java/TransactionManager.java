import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class TransactionManager {
    //make a file writer
    //ArrayList to store all Transactions objects
    private static ArrayList<Transaction> loadTransactionFromFile = new ArrayList<Transaction>();


    //added a transaction to the list
    public static void addTransaction(Transaction transaction) {
        loadTransactionFromFile.add(transaction);
    }

    //Getters to access all transactions
    public ArrayList<Transaction> getTransactions() {
        return loadTransactionFromFile;
    }

    public static void loadTransactionFromFile() {
        // Input file name
        String fileName = "src/main/resources/transaction.csv";

        try {BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/transaction.csv"));

            String header = bufferedReader.readLine(); //skips the header line


            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }

                String[] parts = line.split("\\|");

                LocalDate date = LocalDate.parse(parts[0]);
                LocalTime time = LocalTime.parse(parts[1]);
                String description = parts[2].trim();
                String vendor = parts[3].trim();
                Double amount = Double.parseDouble(parts[4].trim());
                Transaction t = new Transaction(date, time, description, vendor, amount);
                loadTransactionFromFile.add(t);
            }

        } catch (FileNotFoundException e) {
            System.err.println("File doesn't exist" + e);
        } catch (IOException e) {
            System.err.println("Problem reading the file " + e);
        }


    }
    public static void saveTransactionsToFile () {

        String fileName = "src/main/resources/transactions.csv";

        try {BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/transaction.csv"));

            writer.write("date|time|description|vendor|amount");
            writer.newLine();

            for(Transaction t : loadTransactionFromFile) {
                String line = t.getDate() + "|" + t.getTime() +
                        "|" + t.getDescription() + "|" + t.getVendor() +
                        "|" + t.getAmount();
                writer.write(line);
                writer.newLine();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}



