import React from 'react';
import { useNavigate } from 'react-router-dom';

export const Pagetwo = () => {
  const navigate = useNavigate();
  const gotoPreviousPage = () => {
    navigate('/');
  }
  const gotoNextPage = () => {
    navigate('/pagethree');
  }
  let page2 = (
    <>
      <h3>Page 2</h3>
      <br />
      <br />
      <table>
        <tr>
          <th><button onClick={gotoPreviousPage}>Previous</button></th>
          <th><button onClick={gotoNextPage}>Next</button></th>
        </tr>
      </table>
    </>
  );
  return page2;
}