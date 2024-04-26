import React, { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

export const Pagethree = (props) => {
  const location = useLocation();
  const navigate = useNavigate();
  const firstname = location.state.firstname;
  const lastname = location.state.lastname;
  const profession = location.state.profession;
  const address = location.state.address;

  const [creditcard, setCreditcard] = useState("");
  const [type, setType] = useState("");

  const handleOnSubmit = () => {
    navigate('/pagefour', {
      state: {
        firstname,
        lastname,
        profession,
        address,
        creditcard,
        type
      }
    });
  }

  let page3 = (
    <div>
      <div>Firstname: {firstname}</div>
      <div>Lastname: {lastname}</div>
      <div>Profession: {profession}</div>
      <div>Address: {address}</div>
      <>
        <h3>Page 3</h3>
        <div>
          Creditcard number
          <input
            type="text"
            placeholder="Creditcard number"
            value={creditcard}
            onChange={e => setCreditcard(e.target.value)} />
        </div>
        <div>
          Type
          <select
            value={type}
            onChange={e => setType(e.target.value)} >
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