// src/App.js
import React from 'react';
import Button from './Button'; // Import the Button component

function App() {
  return (
    <table>
    <tr>
        <td><Button buttonText="Say Hello from button 1" alertMessage="Hello from button 1" /></td>
        <td><Button buttonText="Say Welcome from button 2" alertMessage="Welcome from button 2" /></td>
    </tr>
    <tr>
        <td><Button buttonText="Say Hi from button 3" alertMessage="Hi from button 3" /></td>
        <td><Button buttonText="Say Goodbye from button 4" alertMessage="Goodbye from button 4" /></td>
    </tr>
</table>
  );
}

export default App;
