package mvc.web;

import mvc.domain.Book;
import mvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable String isbn) {
        Book Book = bookService.findByIsbn(isbn);
        if (Book == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with isbn= "
                    + isbn + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(Book, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<?> addBook(@Valid  @RequestBody Book Book) {
        bookService.add(Book);
        return new ResponseEntity<Book>(Book, HttpStatus.OK);
    }

    @DeleteMapping("/books/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable String isbn) {
        Book book = bookService.findByIsbn(isbn);
        if (book == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with isbn= " + isbn + " is not available"),HttpStatus.NOT_FOUND);
        }
        bookService.delete(isbn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<?> updateBook(@PathVariable String isbn, @RequestBody Book Book) {
        bookService.update(Book);
        return new ResponseEntity<Book>(Book, HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks() {
        Books allbooks = new Books(bookService.findAll());
        return new ResponseEntity<Books>(allbooks, HttpStatus.OK);
    }
    @GetMapping("/books/author/{author}")
    public ResponseEntity<?> searchBooks(@PathVariable String author) {
        Books allbooks = new Books(bookService.findByAuthor(author));
        if (allbooks.getBooks().isEmpty()) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with author= "
                    + author + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Books>(allbooks, HttpStatus.OK);
    }
}
