package mvc.data;
import mvc.service.BankAccountDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface BankRepository extends MongoRepository<BankAccountDTO, Integer> {

    BankAccountDTO findByAccountNumber(Integer accountNumber);

    List<BankAccountDTO> findByAccountHolder(String accountHolder);

    void removeAllBy(Integer accountNumber);

    void removeBy(Integer accountNumber);

    List<BankAccountDTO> findAll();
}
