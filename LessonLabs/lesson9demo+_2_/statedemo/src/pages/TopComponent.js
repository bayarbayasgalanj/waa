import React from 'react';

export const TopComponent = ({ setMessageFunction }) => {

  const sayHello = () => {
    setMessageFunction("Hello was clicked.");
  }

  const sayGoodbye = () => {
    setMessageFunction("Good bye was clicked.");
  }

  let content =
    <table>
      <tr>
        <th><button onClick={sayHello}>Say Hello!</button></th>
        <th><button onClick={sayGoodbye}>Say Good bye!</button></th>
      </tr>
    </table>

  return content;
}
