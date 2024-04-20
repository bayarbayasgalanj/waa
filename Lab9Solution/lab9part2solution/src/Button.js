import React from 'react';

function Button({ buttonText, alertMessage }) {
  const handleClick = () => {
    alert(alertMessage);
  };

  return (
    <button onClick={handleClick}>
      {buttonText}
    </button>
  );
}

export default Button;