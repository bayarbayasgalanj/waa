import React from 'react';

export const TopComponent= ({sayHelloFunction,sayGoodbyeFunction} )  => {

    let content = 
      <table>
        <tr>
          <th><button onClick={sayHelloFunction}>Say Hello!</button></th>
          <th><button onClick={sayGoodbyeFunction}>Say Good bye!</button></th>
        </tr>
      </table>

    return content ;
}
