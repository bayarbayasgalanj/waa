import { BrowserRouter, Routes, Route } from 'react-router-dom';
import {BooksList}from './BooksList';


import { AddBook } from './AddBook';
import React, { useState } from 'react';

function App() {
  const initialList = [
    { bookid: "1", isbn: "123456781", title: "Chingis Khan", author: "Mongolia", price: "1000" },
    { bookid: "2", isbn: "123456782", title: "Got", author: "Kishk", price: "100" },
    { bookid: "3", isbn: "123456783", title: "Harry Potter", author: "Bay", price: "200" },
  ];
  const [booklist, setBooklist] = useState(initialList);
  const onAddBook = (book) => {
    setBooklist(booklist.concat(book));
  }
  const onRemoveBook = (bookid) => {
    setBooklist(booklist.filter((book) => book.bookid !== bookid));
  }
  return (
    <div >
      <BrowserRouter>
        <Routes>
          <Route exact path="/" element={<BooksList booklist={booklist}
            removeBookFunction={onRemoveBook} />} />
          <Route path="/addbook" element={<AddBook addBookFunction={onAddBook} />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
