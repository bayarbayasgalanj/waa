package mvc.web;

import mvc.domain.Book;
import mvc.service.BookService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BookQuery implements GraphQLQueryResolver {

    @Autowired
    private BookService bookService;

    public List<Book> getBooks() {
        return bookService.findAll().stream().collect(Collectors.toList());
    }

    public Optional<Book> getBook(final String isbn) {
        return Optional.of(bookService.findByIsbn(isbn));
    }
}
