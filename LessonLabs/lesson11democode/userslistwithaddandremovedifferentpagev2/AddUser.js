import React, { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

export const AddUser = ({addUserFunction}) => {
  const location = useLocation();
  const navigate = useNavigate();
  const cleanuser = { userid: "", firstname: "", lastname: "", email: "" };
  const [user, setUser] = useState(cleanuser);


  const handleSubmit = (e) => { 
    e.preventDefault();
    addUserFunction(user);   
    navigate('/');
  }

  const handleFieldChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  }


  return (
    <div>
      <h2>Add a new user</h2>
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

