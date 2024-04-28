import React, { useState, useEffect } from 'react';
import axios from 'axios';

export const Contacts = () => {
  const cleancontact = { firstName: "", lastName: "", email: "", phone: "" };
  const [contact, setContact] = useState(cleancontact);
  const [contactlist, setContactlist] = useState([]);

  const client = axios.create({
    baseURL: "http://localhost:8080/contacts" 
  });

  React.useEffect(() => {
    loadContacts();
  }, []);

  const handleSubmit = (e) => {
    //prevent POST request
    e.preventDefault();
    console.log("handleSubmit");
    if (contact) {
      console.log("call the server");
      addContact(contact);
    }
    //clear user
    setContact(cleancontact);
    console.log("load contacts");
    loadContacts();
    console.log("load contacts done");
  }

  const loadContacts = () => {
    const contacts = client.get()
      .then((response) => {
        setContactlist(response.data.contacts);
      });
  }

  const addContact = (contact) => {
    client.post("http://localhost:8080/contacts",contact)
        .then((response) => {
          loadContacts();
        }); //add user to the list
  }
  const handleFieldChange = (e) => {
    setContact({ ...contact, [e.target.name]: e.target.value });
  }

  const removeContact = (e) => {
    client.delete("/"+e.target.value)
        .then((response) => {
          loadContacts();
        }); //remove user from the list   
  }

  return (
    <div>
      <h1>Contacts</h1>

      <table border={1}>
        <thead>
          <tr><th>First name</th><th>Last name</th><th>Email</th><th>Phone</th></tr>
        </thead>
        <tbody>
          {contactlist.map(contact => (
            <tr key={contact.firstName}>
              <td>{contact.firstName}</td>
              <td>{contact.lastName}</td>
              <td>{contact.email}</td>
              <td>{contact.phone}</td>
              <td><button onClick={removeContact} value={contact.firstName} >Remove</button></td>
            </tr>
          ))}
        </tbody>
      </table>

      <h2>Add a new Contact</h2>
      <form onSubmit={handleSubmit}>
        <div>
          Firstname
          <input
            type="text"
            placeholder="First name"
            name="firstName"
            value={contact.firstName}
            onChange={handleFieldChange} />
        </div>
        <div>
          Lastname
          <input
            type="text"
            placeholder="Last name"
            name="lastName"
            value={contact.lastName}
            onChange={handleFieldChange} />
        </div>
        <div>
          Email
          <input
            type="text"
            placeholder="Email"
            name="email"
            value={contact.email}
            onChange={handleFieldChange} />
        </div>
        <div>
          Phone
          <input
            type="text"
            placeholder="Phone"
            name="phone"
            value={contact.phone}
            onChange={handleFieldChange} />
        </div>
        <button type="submit">Add Contact</button>
      </form>
    </div>
  );
};

