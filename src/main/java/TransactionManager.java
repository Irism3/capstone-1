import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

// Manages a collection of financial transactions.
public class TransactionManager {

    // ArrayList to store all transaction objects
    private ArrayList<Transaction> transactions = new ArrayList<>();


    //added a transaction to the list
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    //Getters to access all transactions
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void readTransactionFromFile(String filename) {
        // Input file name
        //String fileName = ("src/main/resources/transactions.csv");
        transactions.clear(); //prevents duplicates when reading again

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/transactions.csv"))) {

            // Reads and skips the first line of my file
            String header = bufferedReader.readLine(); //skips the header line


            // Loops through each line in the file
            String line;
            while (true) {
                 line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }

                if (line.trim().isEmpty()){
                    continue;
                }

                String[] parts = line.split("\\|");

                LocalDate date = LocalDate.parse(parts[0]);

                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm[:ss]");
                LocalTime time = LocalTime.parse(parts[1], timeFormatter);

                String description = parts[2].trim();
                String vendor = parts[3].trim();
                Double amount = Double.parseDouble(parts[4].trim());

                // Created a new Transaction object with the parsed data
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

            // Write the header row
            writer.write("date|time|description|vendor|amount");
            writer.newLine();

            // Loop through each transaction in the list
            for (Transaction t : transactions) {
                String line = t.getDate() + "|" + t.getTime() + "|" + t.getDescription() + "|" + t.getVendor() + "|" + t.getAmount();
                writer.write(line);
                writer.newLine();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}



