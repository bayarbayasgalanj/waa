import React, { useState } from 'react';
import { connect } from 'react-redux';
import { updateCalculatorValue } from './redux/actions';

const Calculator = ({ calculatorValue, updateCalculatorValue }) => {
  const [inputValue, setInputValue] = useState('');
  const [firstNumber, setFirstNumber] = useState('');
  const [operator, setOperator] = useState('');

  const handleInputChange = (e) => {
    setInputValue(e.target.value);
  };

  const handleOperatorClick = (op) => {
    setOperator(op);
    setFirstNumber(inputValue);
    setInputValue('');
  };

  const handleEqualsClick = () => {
    const secondNumber = inputValue;
    let result;
    switch (operator) {
      case '+':
        result = parseFloat(firstNumber) + parseFloat(secondNumber);
        break;
      case '-':
        result = parseFloat(firstNumber) - parseFloat(secondNumber);
        break;
      case '*':
        result = parseFloat(firstNumber) * parseFloat(secondNumber);
        break;
      case '/':
        result = parseFloat(firstNumber) / parseFloat(secondNumber);
        break;
      default:
        result = '';
        break;
    }
    updateCalculatorValue(result);
    setFirstNumber('');
    setOperator('');
    setInputValue('');
  };

  return (
    <div className="calculator">
      <input type="number" value={inputValue} onChange={handleInputChange} />
      <button onClick={() => handleOperatorClick('+')}>+</button>
      <button onClick={() => handleOperatorClick('-')}>-</button>
      <button onClick={() => handleOperatorClick('*')}>*</button>
      <button onClick={() => handleOperatorClick('/')}>/</button>
      <button onClick={handleEqualsClick}>=</button>
      <div>Calculator value: {calculatorValue}</div>
    </div>
  );
};

const mapStateToProps = (state) => {
  return {
    calculatorValue: state.calculatorValue,
  };
};

const mapDispatchToProps = {
  updateCalculatorValue,
};

export default connect(mapStateToProps, mapDispatchToProps)(Calculator);
