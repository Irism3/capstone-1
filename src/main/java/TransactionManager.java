import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TransactionManager {

    public ArrayList<Transaction> transactions = new ArrayList<Transaction>();


    //added a transaction to the list
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    //Getters to access all transactions
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void readTransactionFromFile(String s) {
        // Input file name
        String fileName = "src/main/resources/transactions.csv";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/transactions.csv"))) {

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
                transactions.add(t);
            }

        } catch (FileNotFoundException e) {
            System.err.println("File doesn't exist" + e);
        } catch (IOException e) {
            System.err.println("Problem reading the file " + e);
        }


    }

    public void saveTransactionsToFile(String filename) {

        //String fileName = "src/main/resources/transactions.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv"))) {

            writer.write("date|time|description|vendor|amount");
            writer.newLine();

            for (Transaction t : transactions) {
               // String line =
                //String line = t.getDate() + "|" + t.getTime() + "|" + t.getDescription() + "|" + t.getVendor() + "|" + t.getAmount();
                writer.write(toString());
                writer.newLine();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}



