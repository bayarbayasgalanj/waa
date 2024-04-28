import React, { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

export const Pagethree = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const [user, setUser] = useState(location.state);

  const handleOnSubmit = () => {
    navigate("/pagefour", { state: user });
  }

  const handleFieldChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  }

  let page3 = (
    <div>
      <div>First name: {user.firstname}</div>
      <div>Last name: {user.lastname}</div>
      <div>Address: {user.address}</div>
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
        <button onClick={handleOnSubmit}>Next</button>
      </>
    </div>
  );
  return page3;
}