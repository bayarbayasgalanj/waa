package mvc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;

@Document
public class BankAccount {
    @Id
    private int accountNumber;

    @NotEmpty
    @Size(min=2, max=20)
    private String accountHolder;
    private double balance;
    private Collection<BankAccountTransaction> transactions = new ArrayList<BankAccountTransaction>();

    public BankAccount(){}
    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public Collection<BankAccountTransaction> getTransactions() {
        return transactions;
    }
}
