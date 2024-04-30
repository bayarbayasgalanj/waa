import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
export const AddBook = ({ addBookFunction }) => {
    const navigate = useNavigate();
    const cleanbook = {
        bookid: "", 
        isbn: "", 
        title: "", 
        autor: "", 
        price: ""
    };
    const [book, setBook] = useState(cleanbook);
    const handleSubmit = (e) => {
        e.preventDefault();
        addBookFunction(book);
        navigate('/');
    }
    const handleFieldChange = (e) => {
        setBook({ ...book, [e.target.name]: e.target.value });
    }
    return (
        <div>
            <h2>Add a new book</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    Bookid
                    <input type="text" placeholder="Bookid" name="bookid" value={book.bookid} onChange={handleFieldChange}/>
                </div>
                <div>
                    Isbn
                    <input type="text" placeholder="Isbn" name="isbn" value={book.isbn} onChange={handleFieldChange}/>
                </div>
                <div>
                    Title
                    <input type="text" placeholder="Title" name="title" value={book.title} onChange={handleFieldChange}/>
                </div>
                <div>
                    Author
                    <input type="text" placeholder="Author" name="author" value={book.author} onChange={handleFieldChange}/>
                </div>
                <div>
                    Price
                    <input type="float" placeholder="Price" name="price" value={book.price} onChange={handleFieldChange}/>
                </div>
                <button type="submit">Add Book</button>
            </form>
        </div>
    );
};