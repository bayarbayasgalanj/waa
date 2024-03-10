package mvc.web;

import mvc.domain.Book;
import mvc.service.BookDTO;

import java.util.Collection;
import java.util.List;

public class Books {
    private Collection<BookDTO> books;

    public Books(Collection<BookDTO> books) {
        this.books = books;
    }
    public Collection<BookDTO> getBooks() {
        return books;
    }
    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }

}
