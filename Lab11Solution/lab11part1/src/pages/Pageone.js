import React, { useState } from 'react';
import {useNavigate} from 'react-router-dom';


export const Pageone = () => {
  const navigate = useNavigate();
  const [user, setUser] = useState({
    firstname: "",
    lastname: "",
    address: "",
    creditcard: ""
  })
  const handleOnSubmit = () => {
    navigate("/pagetwo", { state: user });
  }
  const handleFieldChange = (e) => {
    setUser({...user,[e.target.name]: e.target.value });
  }

  let page1 = (
    <>
      <h3>Page 1</h3>
      <div>
        FirstName
          <input
          type="text"
          placeholder="FirstName"
          name="firstname"
          onChange={handleFieldChange} />
      </div>
      <div>
      Lastname
          <input
          type="text"
          placeholder="Lastname"
          name="lastname"
          onChange={handleFieldChange} />
      </div>
      <div>
        Profession
          <select
          name="profession"
          onChange={handleFieldChange} >
          <option></option>
          <option>Programmer</option>
          <option>Manager</option>
          <option>Tester</option>
        </select>
      </div>
      <button onClick={handleOnSubmit}>Next</button>
    </>
  );
  return page1;
}