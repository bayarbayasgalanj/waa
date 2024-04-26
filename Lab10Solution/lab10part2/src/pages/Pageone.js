import React, { useState } from 'react';
import {useNavigate} from 'react-router-dom';


export const Pageone = () => {
  const navigate = useNavigate();
  const [firstname, setFirstname] = useState("");
  const [lastname, setLastname] = useState("");
  const [profession, setProfession] = useState("");
  const gotoNextPage = () => {
    navigate('/pagetwo', {state:{firstname:firstname,lastname:lastname,profession:profession}});
  }

  let page1 = (
    <>
      <h3>Page 1</h3>
      <div>
        FirstName
          <input
          type="text"
          placeholder="FirstName"
          value={firstname}
          onChange={e => setFirstname(e.target.value)} />
      </div>
      <div>
      Lastname
          <input
          type="text"
          placeholder="Lastname"
          value={lastname}
          onChange={e => setLastname(e.target.value)} />
      </div>
      <div>
        Profession
          <select
          value={profession}
          onChange={e => setProfession(e.target.value)} >
          <option></option>
          <option>Programmer</option>
          <option>Manager</option>
          <option>Tester</option>
        </select>
      </div>
      <button onClick={gotoNextPage}>Next</button>
    </>
  );
  return page1;
}