import React, { useState, useEffect } from 'react';
import axios from 'axios';

export const Book = () => {
    const cleanbook = {
        isbn: "",
        author: "",
        title: "",
        price: ""
    };
    const [book, setBook] = useState(cleanbook);
    const [booklist, setBooklist] = useState([]);
    const [errors, setErrors] = useState({});

    useEffect(() => {
        loadBooks();
    }, []);

    const validateField = (name, value) => {
        if (!value) {
            return `${name.charAt(0).toUpperCase() + name.slice(1)} is required.`;
        }
        if ((name === 'isbn' || name === 'price') && !/^\d+$/.test(value)) {
            return `${name.charAt(0).toUpperCase() + name.slice(1)} must be numeric.`;
        }
        return '';
    };

    const handleFieldChange = (e) => {
        const { name, value } = e.target;
        const error = validateField(name, value);
        setErrors({
            ...errors,
            [name]: error
        });
        setBook({
            ...book,
            [e.target.name]: value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        let valid = true;
        const newErrors = {};
        Object.keys(book).forEach(key => {
            const error = validateField(key, book[key]);
            if (error) {
                newErrors[key] = error;
                valid = false;
            }
        });
        setErrors(newErrors);
        if (!valid) {
            console.log("Validation failed:", newErrors);
            return;
        }
        console.log("Validation passed, calling the server to add book.");
        addBook(book);
        setBook(cleanbook);
    };

    const addBook = (book) => {
        axios.post("http://localhost:8080/books", book)
            .then((response) => {
                console.log("Added book", response.data);
                loadBooks();
            })
            .catch(error => {
                console.error("Failed to add book", error);
            });
    };

    const loadBooks = () => {
        axios.get("http://localhost:8080/books")
            .then((response) => {
                setBooklist(response.data.books);
            })
            .catch(error => {
                console.error("Failed to load books", error);
            });
    };

    const removeBook = (isbn) => {
        const url = `http://localhost:8080/books/${isbn}`;
        console.log("Removing book with URL=" + url);
        axios.delete(url)
            .then(() => {
                console.log("Removed book " + isbn);
                loadBooks();
            })
            .catch(error => {
                console.error("Failed to remove book", error);
            });
    };

    return (
        <div>
            <h1>Books</h1>
            <button onClick={loadBooks}>Load books</button>
            <table>
                <thead>
                    <tr><th>Isbn</th><th>Author</th><th>Title</th><th>Price</th><th>Action</th></tr>
                </thead>
                <tbody>
                    {booklist.map((book, index) => (
                        <tr key={index}>
                            <td>{book.isbn}</td>
                            <td>{book.author}</td>
                            <td>{book.title}</td>
                            <td>{book.price}</td>
                            <td><button onClick={() => removeBook(book.isbn)}>Remove</button></td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <h2>Add a new Book</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    Isbn
                    <input
                        type="text"
                        placeholder="Isbn"
                        name="isbn"
                        value={book.isbn}
                        onChange={handleFieldChange} />
                    {errors.isbn && <div style={{ color: 'red' }}>{errors.isbn}</div>}
                </div>
                <div>
                    Author
                    <input
                        type="text"
                        placeholder="Author"
                        name="author"
                        value={book.author}
                        onChange={handleFieldChange} />
                    {errors.author && <div style={{ color: 'red' }}>{errors.author}</div>}
                </div>
                <div>
                    Title
                    <input
                        type="text"
                        placeholder="Title"
                        name="title"
                        value={book.title}
                        onChange={handleFieldChange} />
                    {errors.title && <div style={{ color: 'red' }}>{errors.title}</div>}
                </div>
                <div>
                    Price
                    <input
                        type="text"
                        placeholder="Price"
                        name="price"
                        value={book.price}
                        onChange={handleFieldChange} />
                    {errors.price && <div style={{ color: 'red' }}>{errors.price}</div>}
                </div>
                <button type="submit">Add Book</button>
            </form>
        </div>
    );
};

export default Book;