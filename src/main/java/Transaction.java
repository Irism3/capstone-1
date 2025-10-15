import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {

    //creating my  private fields (encapsulation)
    private LocalDate transactionsDate;
    private LocalTime transactionsTime;
    private String description;
    private String vendor;
    private Double amount;

    //Constructor that takes all my values
    //parse the date and time to Strings
    public Transaction(String dateString, String timeString, String description, String vendor, Double amount) {
        this.transactionsDate = LocalDate.parse(dateString);
        this.transactionsTime = LocalTime.parse(timeString);
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;

    }

    //Getters for everything (so it will read details of the transaction)
    public LocalDate getTransactionsDate() {
        return transactionsDate;
    }

    public void setTransactionsDate() {
        this.transactionsDate = transactionsDate;
    }

    public LocalTime getTransactionsTime() {
        return transactionsTime;
    }

    public void setTransactionsTime() {
        this.transactionsTime = transactionsTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


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



