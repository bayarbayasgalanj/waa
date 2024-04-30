import React, { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

export const Pagethree = (props) => {
  const location = useLocation();
  const navigate = useNavigate();
  const [user, setUser] = useState(location.state);
  const handleOnSubmit = () => {
    navigate("/pagefour", { state: user });
  }
  const handleFieldChange = (e) => {
    setUser({...user,[e.target.name]: e.target.value });
  }

  let page3 = (
    <div>
      <div>Firstname: {user.firstname}</div>
      <div>Lastname: {user.lastname}</div>
      <div>Profession: {user.profession}</div>
      <div>Address: {user.street} {user.city}, {user.state}, {user.zip}</div>
      <>
        <h3>Page 3</h3>
        <div>
          Creditcard number
          <input
            type="text"
            placeholder="Creditcard number"
            name="creditcard"
            onChange={handleFieldChange} />
        </div>
        <div>
          Type
          <select
            name="type"
            onChange={handleFieldChange}>
            <option></option>
            <option value="Visa">Visa</option>
            <option value="Mastercard">Mastercard</option>
          </select>
        </div>
        <button onClick={handleOnSubmit}>Next</button>
      </>
    </div>
  );
  return page3;
}