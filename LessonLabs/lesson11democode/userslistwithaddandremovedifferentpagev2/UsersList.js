import React from 'react';
import { useNavigate } from 'react-router-dom';

export const UsersList = ({userlist, removeUserFunction}) => {
  const navigate = useNavigate();

  const handleAddUser = () => {
    navigate('/adduser');
  }

  const removeUser = (e) => {
    removeUserFunction(e.target.value);
  }


  return (
    <div>
      <h1>Users</h1>
      <table>
        <thead><tr><th>Userid</th><th>First name</th><th>Last name</th><th>Email</th></tr></thead>
        <tbody>
          {userlist.map(user => (
            <tr key={user.userid}>
              <td>{user.userid}</td>
              <td>{user.firstname}</td>
              <td>{user.lastname}</td>
              <td>{user.email}</td>
              <td><button onClick={removeUser} value={user.userid} >Remove</button></td>
            </tr>
          ))}
        </tbody>
      </table>
      <button onClick={handleAddUser}>Add User</button>
    </div>
  );
};

