import React from 'react';
import { useLocation} from 'react-router-dom';

export const Pagefour = (props) => {
  const location = useLocation();
  const firstname = location.state.firstname;
  const lastname = location.state.lastname;
  const profession = location.state.profession;
  const address = location.state.address;
  const creditcard = location.state.creditcard;
  const type = location.state.type;

  let page4 = (
    <div>
      <h3>Thank you for your order!</h3>
      <div>Firstname: {firstname}</div>
      <div>Lastname: {lastname}</div>
      <div>Profession: {profession}</div>
      <div>Address: {address}</div>
      <div>Creditcard: {creditcard}</div>
      <div>type: {type}</div>
    </div>
  );
  return page4;
}