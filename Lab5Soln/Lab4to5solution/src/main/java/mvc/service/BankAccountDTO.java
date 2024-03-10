package mvc.service;

import mvc.domain.BankAccountTransaction;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BankAccountDTO {

    @NotNull
    @Min(1)
    private int accountNumber;

    @NotEmpty
    @Size(min=2, max=20)
    private String accountHolder;
    private double balance;
    private Collection<BankAccountTransaction> transactions = new ArrayList<BankAccountTransaction>();
    public BankAccountDTO(){}
    public BankAccountDTO(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", accountHolder='" + accountHolder + '\'' +
                ", balance=" + balance +
                ", transactions=" + transactions +
                '}';
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setAmount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        BankAccountTransaction transaction = new BankAccountTransaction(new Date(), amount, "deposit");
        this.transactions.add(transaction);
        this.balance += amount;
    }
    public void withdraw(double amount) {
        BankAccountTransaction transaction = new BankAccountTransaction(new Date(), amount, "withdraw");
        this.transactions.add(transaction);
        this.balance -= amount;

    }

    public Collection<BankAccountTransaction> getTransactions() {
        return transactions;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setTransactions(Collection<BankAccountTransaction> transactions) {
        this.transactions = transactions;
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
}
