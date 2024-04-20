// src/Counter.js
import React from 'react';

function Counter({ count, increment, decrement, updateMainCounter }) {
    const handleIncrement = () => updateMainCounter(increment);
    const handleDecrement = () => updateMainCounter(-decrement);

    return (
        <table>
            <tr>
                <th><h2>{count}</h2></th>
            </tr>
            <tr>
                <td><button onClick={handleIncrement}>+ {increment}</button></td>
                <td><button onClick={handleDecrement}>- {decrement}</button></td>
            </tr>
        </table>
    );
}

export default Counter;
