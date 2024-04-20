// src/Button.js
import React from 'react';

function Button() {
  const handleClick = () => {
    alert('Hello World');
  };

  return (
    <button onClick={handleClick}>
      Say Hello
    </button>
  );
}

export default Button;
