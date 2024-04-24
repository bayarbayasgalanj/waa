import React from 'react';
import { useNavigate } from 'react-router-dom';

export const Pagethree = () => {
  const navigate = useNavigate();
  const gotoPreviousPage = () => {
    navigate('/pagetwo');
  }

  let page3 = (
    <>
      <h3>Page 3</h3>
      <br />
      <br />
      <table>
        <tr>
          <th><button onClick={gotoPreviousPage}>Previous</button></th>
        </tr>
      </table>
    </>
  );
  return page3;
}