import React, { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

export const Pagethree = (props) => {
  const location = useLocation();
  const navigate = useNavigate();
  const username = location.state.username;
  const address = location.state.address;
  const [creditcard, setCreditcard] = useState("");
 

  const handleOnSubmit = () => {
   // props.history.push("/pagefour", { username: username, address : address, creditcard : creditcard });
    navigate('/pagefour', {state:{username:username, address : address, creditcard : creditcard}});
  }

  let page3 = (
    <div>
      <div>Username: {username}</div>
      <div>Address: {address}</div>
      <>
        <h3>Page 3</h3>
        <div>
          Creditcard number
           <input
            type="text"
            placeholder="Address"
            value={creditcard}
            onChange={e => setCreditcard(e.target.value)} />
        </div>
        <button onClick={handleOnSubmit}>Next</button>
      </>
    </div>
  );
  return page3;
}