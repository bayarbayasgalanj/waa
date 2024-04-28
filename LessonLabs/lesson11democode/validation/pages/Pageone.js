import React, { useState } from 'react';


export const Pageone = (props) => {
  const cleanUser = {
    firstname: "",
    lastname: "",
    email: ""
  }
  const [user, setUser] = useState(cleanUser);

  const [firstnameError, setFirstnameError] = useState({});
  const [lastnameError, setLastnameError] = useState({});
  const [emailError, setEmailError] = useState({});

  const handleOnSubmit = (e) => {
    e.preventDefault();
    const isValid = formValidation();
    if (isValid) {
      setUser(cleanUser);
      alert("Form is valid");
    }
  }

  const formValidation = () => {
    const firstNameErr = {};
    const lastNameErr = {};
    const emailErr = {};
    let isValid = true;

    if (user.firstname.trim().length < 2) {
      firstNameErr.firstNameShort = "First name is too short"
      isValid = false;
    }
    if (user.firstname.trim().length > 10) {
      firstNameErr.firstNameShort = "First name is too long"
      isValid = false;
    }
    if (user.lastname.trim().length < 2) {
      lastNameErr.lastNameShort = "Last name is too short"
      isValid = false;
    }
    if (user.email.trim().length < 5) {
      emailErr.emailShort = "Email is too short"
      isValid = false;
    }
    var pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
    if (!pattern.test(user.email.trim())) {
          emailErr.emailNoEmail = "Email is not correct"
          isValid = false;
    }

    setFirstnameError(firstNameErr);
    setLastnameError(lastNameErr);
    setEmailError(emailErr);
    return isValid;
  }

  const handleFieldChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  }


  let page1 = (
    <div>
      <form onSubmit={handleOnSubmit}>
        <h3>Enter your data</h3>
        <div>
          Firstname
          <input
            type="text"
            placeholder="First name"
            name="firstname"
            value={user.firstname}
            onChange={handleFieldChange} />
          {Object.keys(firstnameError).map((key) => {
            return <div style={{ color: "red" }}>{firstnameError[key]}</div>
          })}
        </div>

        <div>
          Lastname
          <input
            type="text"
            placeholder="Last name"
            name="lastname"
            value={user.lastname}
            onChange={handleFieldChange} />

          {Object.keys(lastnameError).map((key) => {
            return <div style={{ color: "red" }}>{lastnameError[key]}</div>
          })}
        </div>
        <div>
          Email
          <input
            type="text"
            placeholder="Email"
            name="email"
            value={user.email}
            onChange={handleFieldChange} />
          {Object.keys(emailError).map((key) => {
            return <div style={{ color: "red" }}>{emailError[key]}</div>
          })}
        </div>
        <button type="submit">Next</button>
      </form>
    </div>

  );
  return page1;
}