import React from 'react';
import { useLocation} from 'react-router-dom';

export const Pagefour = (props) => {
  const location = useLocation();
  const username = location.state.username;
  const address = location.state.address;
  const creditcard = location.state.creditcard;

  let page4 = (
    <div>
      <h3>Thank you for your order!</h3>
      <div>Username: {username}</div>
      <div>Address: {address}</div>
      <div>Creditcard: {creditcard}</div>
    </div>
  );
  return page4;
}