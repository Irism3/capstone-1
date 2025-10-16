import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    //creating my  private fields (encapsulation)
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private Double amount;

    //Constructor that takes all my values
    //parse the date and time to Strings
    public Transaction(LocalDate date, LocalTime time, String description, String vendor, Double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;

    }

    //Getters for everything (so it will read details of the transaction)
    public LocalDate getDate() {
        return date;
    }

    public void setDate() {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime() {
        this.time = time;
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
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return date + "| " + time.format(timeFormatter) + "|" + description + "|" + vendor + "| " + amount;

    }


}



