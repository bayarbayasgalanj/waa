import React, { useState } from 'react';

export const UsersList = () => {
  const cleanuser = { userid: "", firstname: "", lastname: "", email: "" };
  const [user, setUser] = useState(cleanuser);
  const initialList = [
    { userid: "1", firstname: "Frank", lastname: "Jones", email: "Franky1@gmail.com" },
    { userid: "2", firstname: "John", lastname: "Doe", email: "jdoe@gmail.com" },
    { userid: "3", firstname: "Mary", lastname: "Brown", email: "marybrown@gmail.com" },
  ];
  const [userlist, setUserlist] = useState(initialList);


  return (
    <div>
      <h1>Users</h1>
      <table border="1">
        <thead>
          <tr><th>Userid</th><th>First name</th><th>Last name</th><th>Email</th></tr>
        </thead>
        <tbody>
          {userlist.map(user => (
            <tr key={user.userid}>
              <td>{user.userid}</td>
              <td>{user.firstname}</td>
              <td>{user.lastname}</td>
              <td>{user.email}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

