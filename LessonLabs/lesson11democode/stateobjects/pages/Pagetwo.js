import React, { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';


export const Pagetwo = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const [user, setUser] = useState(location.state);

  const handleOnSubmit = () => {
    navigate("/pagethree", { state: user });
  }

  const handleFieldChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  }

  let page2 = (
    <div>
      <div>First name: {user.firstname}</div>
      <div>Last name: {user.lastname}</div>
      <>
        <h3>Page 2</h3>
        <div>
          Address
          <input
            type="text"
            placeholder="Address"
            name="address"
            onChange={handleFieldChange} />
        </div>
        <button onClick={handleOnSubmit}>Next</button>
      </>
    </div>
  );
  return page2;
}