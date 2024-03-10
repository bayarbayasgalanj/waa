package mvc.service;

import mvc.data.BookRepository;
import mvc.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public void add(BookDTO bookDto){
        Book book = BookAdapter.getBook(bookDto);
        bookRepository.save(book);
    }

    public void update(BookDTO bookDto){
        Book book = BookAdapter.getBook(bookDto);
        bookRepository.removeAllBy(book.getIsbn());
        bookRepository.save(book);
    }

    public BookDTO findByIsbn(String isbn){
           Book book = bookRepository.findByIsbn(isbn);
           return BookAdapter.getBookDTO(book);
    }

    public List<BookDTO> findByAuthor(String author){

        List<Book> books = bookRepository.findByAuthor(author);
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (Book book : books) {
            bookDTOS.add(BookAdapter.getBookDTO(book));
        }
        return bookDTOS;
    }

    public void delete(String isbn){
        bookRepository.removeBy(isbn);
    }

    public Collection<BookDTO> findAll(){
        List<Book> books = bookRepository.findAll();
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (Book book : books) {
            bookDTOS.add(BookAdapter.getBookDTO(book));
        }
        return bookDTOS;

    }
}
