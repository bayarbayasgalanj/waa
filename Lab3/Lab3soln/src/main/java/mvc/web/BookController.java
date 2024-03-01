package mvc.web;

import mvc.domain.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Controller
public class BookController {

    private Map<String, Book> books = new HashMap<String, Book>();

    public BookController() {
        books.put("888999", new Book("888999", "Brown", "MDP", 690.0));
        books.put("555000", new Book("555000", "Jones", "WAA" , 450.0));
    }

    @GetMapping("/books/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable String isbn) {
        Book Book = books.get(isbn);
        if (Book == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with isbn= "
                    + isbn + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(Book, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<?> addBook(@RequestBody Book Book) {
        books.put(Book.getIsbn(), Book);
        return new ResponseEntity<Book>(Book, HttpStatus.OK);
    }

    @DeleteMapping("/books/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable String isbn) {
        Book Book = books.get(isbn);
        if (Book == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with isbn= " + isbn + " is not available"),HttpStatus.NOT_FOUND);
        }
        books.remove(isbn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<?> updateBook(@PathVariable String isbn, @RequestBody Book Book) {
        books.put(isbn, Book);
        return new ResponseEntity<Book>(Book, HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks() {
        Books allbooks = new Books(books.values());
        return new ResponseEntity<Books>(allbooks, HttpStatus.OK);
    }
    public Book findBookByAuthor(String author) {
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            if (entry.getValue().getAuthor().equals(author)) {
                return entry.getValue();
            }
        }
        return null;
    }
    @GetMapping("/books/author/{author}")
    public ResponseEntity<?> searchBooks(@PathVariable String author) {
        Book book = findBookByAuthor(author);
        if (book == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with author= "
                    + author + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
}
