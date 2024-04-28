import React, { useState } from 'react';

export const Customers = () => {
  const cleanuser = { customernumber: "", name: "", phone: "", email: "" };
  const [customer, setCustomer] = useState(cleanuser);
  const [customers, setCustomers] = useState([]);
  const [customernumber, setCustomernumber] = useState("");

  const  fetchCustomer = async() => {
    const url = 'http://localhost:8080/customers/' + customernumber;
    const response = await fetch(url);
    const data = await response.json();
    setCustomer(data);
  }

  const  fetchCustomers = async() => {
    const url = 'http://localhost:8080/customers';
    const response = await fetch(url);
    const data = await response.json();
    setCustomers(data.customers);
  }


  return (
    <div>
      Customer number
      <div>
        <input
          type="text"
          name="customernumber"
          value={customernumber}
          onChange={e => setCustomernumber(e.target.value)} /></div>

      <div><button onClick={e => fetchCustomer()} >Get customer</button></div>

      <div>Customer {customer.customernumber}  {customer.name}  {customer.email}  {customer.phone}</div>

      <div><button onClick={e => fetchCustomers()} >Get customers</button></div>
      <div>
        <table border = {1} >
          <thead>
            <tr><th>Customernumber</th><th>name</th><th>Phone</th><th>Email</th></tr>
          </thead>
          <tbody>
            {customers.map(customer => (
              <tr key={customer.customernumber}>
                <td>{customer.customernumber}</td>
                <td>{customer.name}</td>
                <td>{customer.phone}</td>
                <td>{customer.email}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

