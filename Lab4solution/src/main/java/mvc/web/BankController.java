package mvc.web;

import mvc.domain.BankAccount;
import mvc.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Controller
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping("/bankAccounts/{accountNumber}")
    public ResponseEntity<?> getAccount(@PathVariable Integer accountNumber) {
        BankAccount bankAccount = bankService.findByAccountNumber(accountNumber);
        if (bankAccount == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Bank Accounts with bankAccount= "
                    + accountNumber + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BankAccount>(bankAccount, HttpStatus.OK);
    }
    @GetMapping("/bankAccounts")
    public ResponseEntity<?> getAllBankAccounts() {
        Collection<BankAccount> allBankAccounts = bankService.findAll();
        return new ResponseEntity<>(allBankAccounts, HttpStatus.OK);
    }
    @PostMapping("/createAccount")
    public ResponseEntity<?> createAccount(@RequestBody @Valid BankAccount bankAccount) {
        bankService.add(bankAccount);
        return new ResponseEntity<BankAccount>(bankAccount, HttpStatus.OK);
    }
    @DeleteMapping("/bankAccounts/{accountNumber}")
    public ResponseEntity<?> removeAccount(@PathVariable Integer accountNumber) {
        BankAccount bankAccount = bankService.findByAccountNumber(accountNumber);
        if (bankAccount == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Bank Accounts with accountNumber= " + accountNumber + " is not available"),HttpStatus.NOT_FOUND);
        }
        bankService.delete(accountNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/bankAccounts/deposit/{accountNumber}/{amount}")
    public ResponseEntity<?> deposit(@PathVariable Integer accountNumber, @PathVariable double amount) {
        BankAccount bA = bankService.findByAccountNumber(accountNumber);
        if (bA == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Bank Accounts with accountNumber= " + accountNumber + " is not available"),HttpStatus.NOT_FOUND);
        }
        bA.deposit(amount);
        return new ResponseEntity<CustomErrorType>(new CustomErrorType("Bank Accounts with accountNumber= " + accountNumber + " added "+amount+". After that total residual amount "+bA.getBalance()), HttpStatus.OK);
    }
    @PutMapping("/bankAccounts/withdraw/{accountNumber}/{amount}")
    public ResponseEntity<?> withdraw(@PathVariable Integer accountNumber, @PathVariable double amount) {
        BankAccount bA = bankService.findByAccountNumber(accountNumber);
        if (bA == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Bank Accounts with accountNumber= " + accountNumber + " is not available"),HttpStatus.NOT_FOUND);
        }
        bA.withdraw(amount);
        return new ResponseEntity<CustomErrorType>(new CustomErrorType("Bank Accounts with accountNumber= " + accountNumber + " withdraw "+amount+". After that total residual amount "+bA.getBalance()), HttpStatus.OK);
    }

}
