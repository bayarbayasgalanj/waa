import React from 'react';
import { Link } from "react-router-dom";

export const Pageone = () => {
  let page1 = (
    <>
      <h3>Page 1</h3>

      <p><Link to="/">Homepage</Link></p>
      <p><Link to="/pageone">Page one</Link></p>
      <p><Link to="/pagetwo">Page two</Link></p>
      <p><Link to="/pagethree">Page three</Link></p>

    </>
  );
  return page1;
}