import React, { useState, useEffect } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

export const Pagetwo = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const [user, setUser] = useState(location.state);
  const handleOnSubmit = () => {
    navigate("/pagethree", { state: user });
  }
  const handleFieldChange = (e) => {
    setUser({...user,[e.target.name]: e.target.value });
  }

  return (
    <div>
      <div>Firstname: {user.firstname}</div>
      <div>Lastname: {user.lastname}</div>
      <div>Profession: {user.profession}</div>
      <h3>Page 2</h3>
      <form>
        <div>
          Street
          <input
            type="text"
            placeholder="Street"
            name="street"
            onChange={handleFieldChange} />
        </div>
        <div>
          City
          <input
            type="text"
            placeholder="City"
            name="city"
            onChange={handleFieldChange} />
        </div>
        <div>
          Zip
          <input
            type="text"
            placeholder="Zip"
            name="zip"
            onChange={handleFieldChange} />
        </div>
        <div>
          State
          <select
            name="state"
            onChange={handleFieldChange} >
            <option></option>
            <option value="TX">Texas</option>
            <option value="AI">Alabama</option>
            <option value="CA">California</option>
          </select>
        </div>
        <button onClick={handleOnSubmit}>Next</button>
      </form>
    </div>
  );
}
