import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class TransactionManager {

    //ArrayList to store all Transactions objects
    private ArrayList<Transaction> transactions;

    //Initialized the transaction manager
    //Constructor and creates an empty ArrayList ready to store transactions
    public TransactionManager() {
        transactions = new ArrayList<>();

    }

    //added a transaction to the list
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    //Getters to access all transactions
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void loadTransactionFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine(); //skips the header line

            //Reads the file line by line until it reaches the end
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
            }
            //splits the line into parts using the pipe character as delimiter
            String[] parts = line.split("\\|");

            //making sure I have all fields
            if (parts.length == 5) {

                String date = parts[0].trim();
                String time = parts[1].trim();
                String description = parts[2].trim();
                String vendor = parts[3].trim();
                Double amount = Double.parseDouble(parts[4].trim());

                Transaction t = new Transaction(date, time, description, vendor, amount);
                transactions.add(t);
            }

        } catch (IOException e) {
            System.out.println("Error reading a file:" + e.getMessage());
        }


    }
}