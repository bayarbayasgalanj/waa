import React, { useState } from 'react';
import { useLocation} from 'react-router-dom';

export const Pagefour = (props) => {
  const location = useLocation();
  const [user] = useState(location.state);
  
  let page4 = (
    <div>
      <h3>Thank you for your order!</h3>
      <div>Firstname: {user.firstname}</div>
      <div>Lastname: {user.lastname}</div>
      <div>Profession: {user.profession}</div>
      <div>Address: {user.street} {user.city}, {user.state}, {user.zip}</div>
      <div>Creditcard: {user.creditcard}</div>
      <div>type: {user.type}</div>
    </div>
  );
  return page4;
}