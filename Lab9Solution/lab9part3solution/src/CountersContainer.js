import React from 'react';
import Counter from './Counter';

function CountersContainer() {
    return (
        <table>
            <tr>
                <td><Counter initialCount={7} increment={1} decrement={1} /></td>
                <td><Counter initialCount={-15} increment={3} decrement={3} /></td>
            </tr>
            <tr>
                <td><Counter initialCount={10} increment={5} decrement={5} /></td>
                <td><Counter initialCount={48} increment={8} decrement={8} /></td>
            </tr>
        </table>
    );
}

export default CountersContainer;