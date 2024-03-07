package mvc.service;

import mvc.data.BankRepository;
import mvc.domain.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;
@Service
public class BankService {

    @Autowired
    BankRepository bankRepository;

    public void add(BankAccount bankAccount){
        bankRepository.save(bankAccount);
    }

    public void update(BankAccount bankAccount){
        bankRepository.save(bankAccount);
    }

    public BankAccount findByAccountNumber(Integer accountNumber){
        return bankRepository.findByAccountNumber(accountNumber);
    }

    public List<BankAccount> findByBankAccountHolder(String accountHolder){
        return bankRepository.findByAccountHolder(accountHolder);
    }

    public void delete(Integer accountNumber){
        bankRepository.delete(accountNumber);
    }

    public Collection<BankAccount> findAll(){
        return bankRepository.findAll();
    }
}
