import React, { useState } from 'react';

function Counter({ initialCount, increment, decrement }) {
    const [count, setCount] = useState(initialCount);

    return (

        <table>
            <tr>
                <th><h2>{count}</h2></th>
            </tr>
            <tr>
                <td><button onClick={() => setCount(count + increment)}>+ {increment}</button></td>
                <td><button onClick={() => setCount(count - decrement)}>- {decrement}</button></td>
            </tr>
        </table>
    );
}

export default Counter;