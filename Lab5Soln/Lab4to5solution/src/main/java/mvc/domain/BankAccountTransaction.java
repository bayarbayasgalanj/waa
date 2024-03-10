package mvc.domain;

import java.util.Date;

public class BankAccountTransaction {
    private Date date;
    private Double amount;
    private String type;
    public BankAccountTransaction() {
    }

    @Override
    public String toString() {
        return "BankAccountTransaction{" +
                "date=" + date +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public BankAccountTransaction(Date date, Double amount, String type) {
        this.date = date;
        this.amount = amount;
        this.type = type;
    }
}
