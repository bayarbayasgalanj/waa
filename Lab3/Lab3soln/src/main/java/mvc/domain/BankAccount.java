package mvc.domain;

import java.util.*;

public class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private Collection<BankAccountTransaction> transactions = new ArrayList<BankAccountTransaction>();
    public BankAccount() {
    }

    public BankAccount(int accountNumber, String accountHolder, double balance) {
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
