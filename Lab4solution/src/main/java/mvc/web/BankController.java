package mvc.web;

import mvc.domain.BankAccount;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@Controller
public class BankController {

    private Map<Integer, BankAccount> bankAccounts = new HashMap<Integer, BankAccount>();

    public BankController() {
        bankAccounts.put(888999, new BankAccount(888999, "Bayar", 100.0));
        bankAccounts.put(555000, new BankAccount(555000, "Shujat", 200.0));
    }

    @GetMapping("/bankAccounts/{accountNumber}")
    public ResponseEntity<?> getAccount(@PathVariable Integer accountNumber) {
        BankAccount bankAccount = bankAccounts.get(accountNumber);
        if (bankAccount == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Bank Accounts with bankAccount= "
                    + accountNumber + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BankAccount>(bankAccount, HttpStatus.OK);
    }
    @PostMapping("/createAccount")
    public ResponseEntity<?> createAccount(@RequestBody BankAccount bankAccount) {
        bankAccounts.put(bankAccount.getAccountNumber(), bankAccount);
        return new ResponseEntity<BankAccount>(bankAccount, HttpStatus.OK);
    }
    @DeleteMapping("/bankAccounts/{accountNumber}")
    public ResponseEntity<?> removeAccount(@PathVariable Integer accountNumber) {
        BankAccount bankAccount = bankAccounts.get(accountNumber);
        if (bankAccount == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Bank Accounts with accountNumber= " + accountNumber + " is not available"),HttpStatus.NOT_FOUND);
        }
        bankAccounts.remove(accountNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/bankAccounts/deposit/{accountNumber}/{amount}")
    public ResponseEntity<?> deposit(@PathVariable Integer accountNumber, @PathVariable double amount) {
        BankAccount bA = bankAccounts.get(accountNumber);
        if (bA == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Bank Accounts with accountNumber= " + accountNumber + " is not available"),HttpStatus.NOT_FOUND);
        }
        bA.deposit(amount);
        return new ResponseEntity<CustomErrorType>(new CustomErrorType("Bank Accounts with accountNumber= " + accountNumber + " added "+amount+". After that total residual amount "+bA.getBalance()), HttpStatus.OK);
    }
    @PutMapping("/bankAccounts/withdraw/{accountNumber}/{amount}")
    public ResponseEntity<?> withdraw(@PathVariable Integer accountNumber, @PathVariable double amount) {
        BankAccount bA = bankAccounts.get(accountNumber);
        if (bA == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Bank Accounts with accountNumber= " + accountNumber + " is not available"),HttpStatus.NOT_FOUND);
        }
        bA.withdraw(amount);
        return new ResponseEntity<CustomErrorType>(new CustomErrorType("Bank Accounts with accountNumber= " + accountNumber + " withdraw "+amount+". After that total residual amount "+bA.getBalance()), HttpStatus.OK);
    }
}
