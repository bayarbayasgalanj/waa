package mvc.web;

import mvc.service.BankAccountDTO;
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
        BankAccountDTO bankAccountDTO = bankService.findByAccountNumber(accountNumber);
        if (bankAccountDTO == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Bank Accounts with bankAccount= "
                    + accountNumber + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BankAccountDTO>(bankAccountDTO, HttpStatus.OK);
    }
    @GetMapping("/bankAccounts")
    public ResponseEntity<?> getAllBankAccounts() {
        Collection<BankAccountDTO> allBankAccountDTOS = bankService.findAll();
        return new ResponseEntity<>(allBankAccountDTOS, HttpStatus.OK);
    }
    @PostMapping("/createAccount")
    public ResponseEntity<?> createAccount(@RequestBody @Valid BankAccountDTO bankAccountDTO) {
        bankService.add(bankAccountDTO);
        return new ResponseEntity<BankAccountDTO>(bankAccountDTO, HttpStatus.OK);
    }
    @DeleteMapping("/bankAccounts/{accountNumber}")
    public ResponseEntity<?> removeAccount(@PathVariable Integer accountNumber) {
        BankAccountDTO bankAccountDTO = bankService.findByAccountNumber(accountNumber);
        if (bankAccountDTO == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Bank Accounts with accountNumber= " + accountNumber + " is not available"),HttpStatus.NOT_FOUND);
        }
        bankService.delete(accountNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/bankAccounts/deposit/{accountNumber}/{amount}")
    public ResponseEntity<?> deposit(@PathVariable Integer accountNumber, @PathVariable double amount) {
        BankAccountDTO bA = bankService.findByAccountNumber(accountNumber);
        if (bA == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Bank Accounts with accountNumber= " + accountNumber + " is not available"),HttpStatus.NOT_FOUND);
        }
        bankService.deposit(bA, amount);
        return new ResponseEntity<CustomErrorType>(new CustomErrorType("Bank Accounts with accountNumber= " + accountNumber + " added "+amount+". After that total residual amount "+bA.getBalance()), HttpStatus.OK);
    }
    @PutMapping("/bankAccounts/withdraw/{accountNumber}/{amount}")
    public ResponseEntity<?> withdraw(@PathVariable Integer accountNumber, @PathVariable double amount) {
        BankAccountDTO bA = bankService.findByAccountNumber(accountNumber);
        if (bA == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Bank Accounts with accountNumber= " + accountNumber + " is not available"),HttpStatus.NOT_FOUND);
        }
        bankService.withdraw(bA, amount);
        return new ResponseEntity<CustomErrorType>(new CustomErrorType("Bank Accounts with accountNumber= " + accountNumber + " withdraw "+amount+". After that total residual amount "+bA.getBalance()), HttpStatus.OK);
    }

}
