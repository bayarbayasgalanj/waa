package mvc.web;

import mvc.domain.BankAccount;
import mvc.service.BankAccountDTO;
import mvc.service.BankService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AccountQuery implements GraphQLQueryResolver {

    @Autowired
    private BankService accountService;

    public List<BankAccountDTO> getAccounts() {
        return accountService.findAll().stream().collect(Collectors.toList());
    }

    public Optional<BankAccountDTO> getAccount(final int accountNumber) {
        return Optional.of(accountService.findByAccountNumber(accountNumber));
    }
}
