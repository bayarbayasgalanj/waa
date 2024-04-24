import React, { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';


export const Pagetwo = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const username = location.state.username;
  const [address, setAddress] = useState("");
  const handleOnSubmit = () => {
 //   props.history.push("/pagethree", { username: username, address : address });
      navigate('/pagethree', {state:{username:username, address : address}});
  }
  let page2 = (
    <div>
    <div>Username: {username}</div>
    <>
      <h3>Page 2</h3>
      <div>
        Address
         <input
          type="text"
          placeholder="Address"
          value={address}
          onChange={e => setAddress(e.target.value)} />
      </div>
      <button onClick={handleOnSubmit}>Next</button>
    </>
  </div>
);
return page2;
}