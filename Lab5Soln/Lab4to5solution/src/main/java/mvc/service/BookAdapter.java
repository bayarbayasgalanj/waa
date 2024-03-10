package mvc.service;


import mvc.domain.Book;

public class BookAdapter {

    public static Book getBook(BookDTO bookDto){
        Book book = new Book();
        if (bookDto != null) {
            book = new Book(bookDto.getIsbn(),
                    bookDto.getAuthor(),
                    bookDto.getTitle(),
                    bookDto.getPrice());
            return book;
        }
        return null;
    }

    public static BookDTO getBookDTO(Book book){
        BookDTO bookDto = new BookDTO();
        if (book != null) {
            bookDto = new BookDTO(book.getIsbn(),
                    book.getAuthor(),
                    book.getTitle(),
                    book.getPrice());
            return bookDto;
        }else{
            return null;
        }

    }
}
