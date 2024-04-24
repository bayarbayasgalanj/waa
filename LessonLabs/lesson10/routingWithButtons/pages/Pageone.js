import React from 'react';
import {useNavigate} from 'react-router-dom';


export const Pageone = () => {
  const navigate = useNavigate();
  const gotoNextPage = () => {
    navigate('/pagetwo');
  }

  let page1 = (
    <>
      <h3>Page 1</h3>
      <br />
      <br />
      <button onClick={gotoNextPage}>Next</button>
    </>
  );
  return page1;
}