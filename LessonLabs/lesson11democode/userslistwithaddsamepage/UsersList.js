import React, { useState } from 'react';

export const UsersList = () => {
  const cleanuser = { userid: "", firstname: "", lastname: "", email: "" };
  const [user, setUser] = useState(cleanuser);
  const initialList = [
    { userid: "1", firstname: "Frank", lastname: "Jones", email: "Franky1@gmail.com" },
    { userid: "2", firstname: "John", lastname: "Doe", email: "jdoe@gmail.com" },
  ];
  const [userlist, setUserlist] = useState(initialList);

  const handleSubmit = (e) => {
    if (user) {
      setUserlist(userlist.concat(user)); //add user to the list
    }
    //clear user
    setUser(cleanuser);
    //prevent POST request
    e.preventDefault();
  }

  const handleFieldChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  }

  return (
    <div>
      <h1>Users</h1>

      <table>
        <tr><th>Userid</th><th>First name</th><th>Last name</th><th>Email</th></tr>
        {userlist.map(user => (
          <tr><td>{user.userid}</td>
            <td>{user.firstname}</td>
            <td>{user.lastname}</td>
            <td>{user.email}</td></tr>
        ))}
      </table>
      <p><h2>Add a new user</h2></p>
      <form onSubmit={handleSubmit}>
        <div>
          Userid
          <input
            type="text"
            placeholder="Userid"
            name="userid"
            value={user.userid}
            onChange={handleFieldChange} />
        </div>
        <div>
          Firstname
          <input
            type="text"
            placeholder="First name"
            name="firstname"
            value={user.firstname}
            onChange={handleFieldChange} />
        </div>
        <div>
          Lastname
          <input
            type="text"
            placeholder="Last name"
            name="lastname"
            value={user.lastname}
            onChange={handleFieldChange} />
        </div>
        <div>
          Email
          <input
            type="text"
            placeholder="Email"
            name="email"
            value={user.email}
            onChange={handleFieldChange} />
        </div>
        <button type="submit">Add User</button>
      </form>
    </div>
  );
};

