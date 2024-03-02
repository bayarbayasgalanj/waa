package mvc.data;

import mvc.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookRepository {
    private Map<String, Book> books = new HashMap<String, Book>();

    public void save(Book book){
        books.put(book.getIsbn(),book);
    }

    public Book findByIsbn(String isbn){
        return books.get(isbn);
    }

    public List<Book> findByAuthor(String author){
        List<Book> bs = new ArrayList<Book>();
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            if (entry.getValue().getAuthor().equals(author)) {
                bs.add(entry.getValue());
            }
        }
        return bs;
    }

    public void delete(String firstName){
        books.remove(firstName);
    }

    public Collection<Book> findAll(){
        return books.values();
    }
}
