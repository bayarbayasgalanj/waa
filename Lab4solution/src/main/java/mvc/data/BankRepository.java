package mvc.data;
import mvc.domain.BankAccount;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BankRepository {
    private Map<Integer, BankAccount> bankaccounts = new HashMap<Integer, BankAccount>();

    public void save(BankAccount bankAccount){
        bankaccounts.put(bankAccount.getAccountNumber(),bankAccount);
    }

    public BankAccount findByAccountNumber(Integer accountNumber){
        return bankaccounts.get(accountNumber);
    }

    public List<BankAccount> findByAccountHolder(String accountHolder){
        List<BankAccount> bs = new ArrayList<BankAccount>();
        for (Map.Entry<Integer, BankAccount> entry : bankaccounts.entrySet()) {
            if (entry.getValue().getAccountHolder().equals(accountHolder)) {
                bs.add(entry.getValue());
            }
        }
        return bs;
    }

    public void delete(Integer accountNumber){
        bankaccounts.remove(accountNumber);
    }

    public Collection<BankAccount> findAll(){
        return bankaccounts.values();
    }
}
