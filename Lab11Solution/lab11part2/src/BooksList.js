import React from 'react';
import { useNavigate } from 'react-router-dom';
export const BooksList = ({ booklist, removeBookFunction }) => {
    const navigate = useNavigate();
    const handleAddBook = () => {
        navigate('/addbook');
    }
    const removeBook = (e) => {
        removeBookFunction(e.target.value);
    }
    return (
        <div>
            <h1>Books</h1>
            <table>
                <thead><tr><th>Bookid</th><th>First name</th><th>Last name</th><th>Email</th>
                </tr></thead>
                <tbody>
                    {booklist.map(book => (
                        <tr key={book.bookid}>
                            <td>{book.bookid}</td>
                            <td>{book.isbn}</td>
                            <td>{book.author}</td>
                            <td>{book.price}</td>
                            <td><button onClick={removeBook} value={book.bookid} >Remove</button></td
                            >
                        </tr>
                    ))}
                </tbody>
            </table>
            <button onClick={handleAddBook}>Add Book</button>
        </div>
    );
}