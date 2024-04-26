import React, { useState, useEffect } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

export const Pagetwo = () => {
  const location = useLocation();
  const navigate = useNavigate();

  // Default values to prevent undefined errors if no state is passed
  const { firstname = '', lastname = '', profession = '' } = location.state || {};

  const [city, setCity] = useState("");
  const [street, setStreet] = useState("");
  const [zip, setZip] = useState("");
  const [state, setState] = useState("");
  const [address, setAddress] = useState("");

  useEffect(() => {
    setAddress(`${street} ${city} ${zip} ${state}`);
  }, [street, city, zip, state]);

  const handleOnSubmit = (e) => {
    e.preventDefault(); // Prevent the default form submission behavior
    navigate('/pagethree', {
      state: {
        firstname,
        lastname,
        profession,
        address
      }
    });
  }

  return (
    <div>
      <div>Firstname: {firstname}</div>
      <div>Lastname: {lastname}</div>
      <div>Profession: {profession}</div>
      <h3>Page 2</h3>
      <form onSubmit={handleOnSubmit}>
        <div>
          Street
          <input
            type="text"
            placeholder="Street"
            value={street}
            onChange={e => setStreet(e.target.value)} />
        </div>
        <div>
          City
          <input
            type="text"
            placeholder="City"
            value={city}
            onChange={e => setCity(e.target.value)} />
        </div>
        <div>
          Zip
          <input
            type="text"
            placeholder="Zip"
            value={zip}
            onChange={e => setZip(e.target.value)} />
        </div>
        <div>
          State
          <select
            value={state}
            onChange={e => setState(e.target.value)} >
            <option></option>
            <option value="TX">Texas</option>
            <option value="AI">Alabama</option>
            <option value="CA">California</option>
          </select>
        </div>
        <button type="submit">Next</button>
      </form>
    </div>
  );
}
