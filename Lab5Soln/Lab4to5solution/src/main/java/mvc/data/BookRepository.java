package mvc.data;

import mvc.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {

    Book findByIsbn(String isbn);

    List<Book> findByAuthor(String author);

    void removeAllBy(String isbn);

    void removeBy(String isbn);

    List<Book> findAll();
}
