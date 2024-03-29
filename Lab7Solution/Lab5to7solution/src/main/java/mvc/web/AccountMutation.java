package mvc.web;

import mvc.service.BankAccountDTO;
import mvc.service.BankService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AccountMutation implements GraphQLMutationResolver {

    @Autowired
    private BankService accountService;

    public BankAccountDTO createAccount(final int accountNumber, final String accountHolder) {
        BankAccountDTO accountDTO = new BankAccountDTO(accountNumber, accountHolder);
        accountService.add(accountDTO);
        return accountDTO;
    }
    public int deposit(final int accountNumber, final Double amount, final String desription) {
        BankAccountDTO bA = accountService.findByAccountNumber(accountNumber);
        accountService.deposit(bA ,amount);
        return accountNumber;
    }

    public int withdraw(final int accountNumber, final Double amount, final String desription) {
        BankAccountDTO bA = accountService.findByAccountNumber(accountNumber);
        accountService.withdraw(bA ,amount);
        return accountNumber;
    }

}