import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { UsersList } from './UsersList';
import { AddUser } from './AddUser';
import React, { useState } from 'react';

function App() {

const initialList = [
  { userid: "1", firstname: "Frank", lastname: "Jones", email: "Franky1@gmail.com" },
  { userid: "2", firstname: "John", lastname: "Doe", email: "jdoe@gmail.com" },
  { userid: "3", firstname: "Mary", lastname: "Brown", email: "marybrown@gmail.com" },
];
const [userlist, setUserlist] = useState(initialList);

const onAddUser = (user) => {
    setUserlist(userlist.concat(user)) ;
}

const onRemoveUser = (userid) => {
    setUserlist(userlist.filter((user) => user.userid !== userid)) ;
}

  return (
    <div >
      <BrowserRouter>
        <Routes>
          <Route exact path="/" element={<UsersList userlist={userlist} removeUserFunction={onRemoveUser}/>} />
          <Route path="/adduser" element={<AddUser addUserFunction={onAddUser}/>} />
        </Routes>
      </BrowserRouter>
    </div>

  );
}

export default App;
