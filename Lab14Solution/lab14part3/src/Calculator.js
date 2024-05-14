import React, { useState } from 'react';

function Calculator() {
    const [number1, setNumber1] = useState(0);
    const [number2, setNumber2] = useState(0);
    const [result, setResult] = useState(0);

    const handleNumber1Change = (e) => setNumber1(Number(e.target.value));
    const handleNumber2Change = (e) => setNumber2(Number(e.target.value));

    const add = () => setResult(number1 + number2);
    const subtract = () => setResult(number1 - number2);
    const multiply = () => setResult(number1 * number2);

    return (
        <div>
            <input type="number" value={number1} onChange={handleNumber1Change} />
            <input type="number" value={number2} onChange={handleNumber2Change} />
            <button onClick={add}>Add</button>
            <button onClick={subtract}>Subtract</button>
            <button onClick={multiply}>Multiply</button>
            <h2>Result: {result}</h2>
        </div>
    );
}

export default Calculator;
