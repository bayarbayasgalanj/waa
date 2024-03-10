package mvc.service;


import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class BookDTO {
    @NotEmpty
    @Size(min=2, max=10)
    @Id
    private String isbn;
    @NotEmpty
    private String author;
    @NotEmpty
    private String title;

    private double price;

    public BookDTO() {

    }

    public BookDTO(String isbn, String author, String title, double price) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
