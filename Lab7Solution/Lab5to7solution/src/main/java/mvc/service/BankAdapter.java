package mvc.service;
import mvc.domain.BankAccount;

public class BankAdapter {

    public static BankAccount getBankAccount(BankAccountDTO bookDto){
        BankAccount book = new BankAccount();
        if (bookDto != null) {
            book = new BankAccount(bookDto.getAccountNumber(),
                    bookDto.getAccountHolder(),
                    bookDto.getBalance());
            return book;
        }
        return null;
    }

    public static BankAccountDTO getBankAccountDTO(BankAccount book){
        BankAccountDTO bookDto = new BankAccountDTO();
        if (book != null) {
            bookDto = new BankAccountDTO(book.getAccountNumber(),
                    book.getAccountHolder(),
                    book.getBalance());
            return bookDto;
        }else{
            return null;
        }

    }
}
