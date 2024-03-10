package mvc.service;

import mvc.data.BankRepository;
import mvc.domain.BankAccount;
import mvc.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;
@Service
public class BankService {

    @Autowired
    BankRepository bankRepository;

    public void add(BankAccountDTO bankAccountDTO){
        bankRepository.save(bankAccountDTO);
    }

    public void update(BankAccountDTO bankAccountDTO){
        BankAccount bankAccount = BankAdapter.getBankAccount(bankAccountDTO);
        bankRepository.removeAllBy(bankAccount.getAccountNumber());
        bankRepository.save(bankAccountDTO);
    }
    public void withdraw(BankAccountDTO bankAccountDTO, Double amount){
        bankAccountDTO.withdraw(amount);
        update(bankAccountDTO);
    }
    public void deposit(BankAccountDTO bankAccountDTO, Double amount){
        bankAccountDTO.deposit(amount);
        update(bankAccountDTO);
    }

    public BankAccountDTO findByAccountNumber(Integer accountNumber){
        return bankRepository.findByAccountNumber(accountNumber);
    }

    public List<BankAccountDTO> findByBankAccountHolder(String accountHolder){
        return bankRepository.findByAccountHolder(accountHolder);
    }

    public void delete(Integer accountNumber){
        bankRepository.removeBy(accountNumber);
    }

    public Collection<BankAccountDTO> findAll(){
        return bankRepository.findAll();
    }
}
