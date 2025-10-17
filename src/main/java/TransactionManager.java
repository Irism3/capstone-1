import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

// Manages a collection of financial transactions.
public class TransactionManager {

    // Created a list to store all transactions objects in memory
    private ArrayList<Transaction> transactions = new ArrayList<>();


    // Method to add a transaction
    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    // Method to get all transactions
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    // Method to read transactions from file
    public void readTransactionFromFile(String filename) {
        transactions.clear(); //prevents duplicates when reading again

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/transactions.csv"))) {

            // Skips the header line
            String header = bufferedReader.readLine();


            // Loops through each line in the file
            String line;
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }

                if (line.trim().isEmpty()) {
                    continue;
                }

                //Split line by pipe delimiter
                String[] parts = line.split("\\|");

                LocalDate date = LocalDate.parse(parts[0]);

                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalTime time = LocalTime.parse(parts[1], timeFormatter);

                String description = parts[2].trim();
                String vendor = parts[3].trim();
                Double amount = Double.parseDouble(parts[4].trim());

                // Created and add transaction to list
                Transaction t = new Transaction(date, time, description, vendor, amount);
                transactions.add(t);
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found" + e);
        } catch (IOException e) {
            System.err.println("Error reading the file " + e);
        }


    }

    public void saveTransactionsToFile(String filename) {

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv"))) {


            writer.write("date|time|description|vendor|amount");
            writer.newLine();

            // Write each transaction to file
            for (Transaction t : transactions) {
                String line = t.getDate() + "|" + t.getTime().format(timeFormatter) + "|" + t.getDescription() + "|" + t.getVendor() + "|" + t.getAmount();
                writer.write(line);
                writer.newLine();
            }


        } catch (IOException e) {
            System.err.println("error with file"+ e);
        }

    }


}



