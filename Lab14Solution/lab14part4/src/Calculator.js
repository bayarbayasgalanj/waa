import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function Calculator() {
  const [number1, setNumber1] = useState('');
  const [number2, setNumber2] = useState('');
  const navigate = useNavigate();

  const handleCalculation = (operation) => {
    let result = 0;
    switch (operation) {
      case 'add':
        result = parseInt(number1) + parseInt(number2);
        break;
      case 'subtract':
        result = parseInt(number1) - parseInt(number2);
        break;
      case 'multiply':
        result = parseInt(number1) * parseInt(number2);
        break;
      default:
        return;
    }
    navigate(`/results/${result}`);
  };

  return (
    <div>
      <input type="number" value={number1} onChange={(e) => setNumber1(e.target.value)} />
      <input type="number" value={number2} onChange={(e) => setNumber2(e.target.value)} />
      <button onClick={() => handleCalculation('add')}>Add</button>
      <button onClick={() => handleCalculation('subtract')}>Subtract</button>
      <button onClick={() => handleCalculation('multiply')}>Multiply</button>
    </div>
  );
}

export default Calculator;
