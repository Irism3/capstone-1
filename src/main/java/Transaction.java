import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {

    //creating my  private fields (encapsulation)
    public LocalDate transactionsDate;
    public LocalTime transactionsTime;
    public String description;
    public String vendor;
    public Double amount;

    //Constructor that takes all my values
    public Transaction(LocalDate transactionsDate, LocalTime transactionsTime, String description, String vendor, Double amount) {
        this.transactionsDate = transactionsDate;
        this.transactionsTime = transactionsTime;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;

    }

    //Getters for everything (so it will read details of the transaction)
    public LocalDate getTransactionsDate() {
        return transactionsDate;
    }

    public LocalTime getTransactionsTime() {
        return transactionsTime;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public Double getAmount() {
        return amount;
    }

    // No Setters - I don't want to change a transaction after it's created

    //Created a toString() to display a transaction in a readable format
    @Override
    public String toString() {
        return transactionsDate +
                ", " + transactionsTime +
                ", " + description +
                ", " + vendor +
                ", " + amount;

    }



}



