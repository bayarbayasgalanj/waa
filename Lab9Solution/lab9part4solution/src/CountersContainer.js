import React from 'react';
import Counter from './Counter';

function CountersContainer({ count, updateMainCounter }) {
  return (
    <table>
      <tr>
        <td><Counter count={count} increment={1} decrement={1} updateMainCounter={updateMainCounter} /></td>
        <td><Counter count={count} increment={3} decrement={3} updateMainCounter={updateMainCounter} /></td>
      </tr>
      <tr>
        <td><Counter count={count} increment={5} decrement={5} updateMainCounter={updateMainCounter} /></td>
        <td><Counter count={count} increment={8} decrement={8} updateMainCounter={updateMainCounter} /></td>
      </tr>
    </table>
  );
}

export default CountersContainer;
